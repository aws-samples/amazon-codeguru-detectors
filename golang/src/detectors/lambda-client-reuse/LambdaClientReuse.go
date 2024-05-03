package main

import (
	"context"
	"fmt"
	"log"

	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/s3"
)

var cfg, err = config.LoadDefaultConfig(context.TODO())
var s3Client = s3.NewFromConfig(cfg)

// {fact rule=lambda-client-reuse@v1.0 defects=1}
func LambdaHandlerNoncompliant(ctx context.Context) (string, error) {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Fatalf("Error loading AWS config: %v", err)
	}
	// Noncompliant: Created S3 client inside lambda handler.
	s3Client := s3.NewFromConfig(cfg)

	result, err := s3Client.ListBuckets(ctx, &s3.ListBucketsInput{})
	if err != nil {
		log.Fatalf("Error listing buckets: %v", err)
	}

	var bucketNames []string
	for _, bucket := range result.Buckets {
		if bucket.Name != nil {
			bucketNames = append(bucketNames, *bucket.Name)
		}
	}

	message := fmt.Sprintf("S3 Buckets: %v", bucketNames)
	return message, nil
}

// {/fact}

// {fact rule=lambda-client-reuse@v1.0 defects=0}
func LambdaHandlerCompliant(ctx context.Context) (string, error) {
    // Compliant: reuse S3 client.
	result, err := s3Client.ListBuckets(ctx, &s3.ListBucketsInput{})
	if err != nil {
		log.Fatalf("Error listing buckets: %v", err)
	}

	var bucketNames []string
	for _, bucket := range result.Buckets {
		if bucket.Name != nil {
			bucketNames = append(bucketNames, *bucket.Name)
		}
	}

	message := fmt.Sprintf("S3 Buckets: %v", bucketNames)
	return message, nil
}

// {/fact}
