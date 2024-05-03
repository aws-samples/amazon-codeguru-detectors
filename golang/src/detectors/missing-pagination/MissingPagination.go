package main

import (
	"context"
	"fmt"
)
import "log"
import "github.com/aws/aws-sdk-go-v2/config"
import "github.com/aws/aws-sdk-go-v2/aws"
import "github.com/aws/aws-sdk-go-v2/service/s3"

// {fact rule=missing-pagination@v1.0 defects=1}
func missingPaginationNoncompliant() {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Printf("error: %v", err)
		return
	}

	client := s3.NewFromConfig(cfg)

	params := &s3.ListObjectsV2Input{
		Bucket: aws.String("my-bucket"),
	}

	// Noncompliant: Pagination is missing.
	output, err := client.ListObjectsV2(context.TODO(), params)
	if err != nil {
		log.Printf("error: %v", err)
	}
	fmt.Println(output)
}

// {/fact}

// {fact rule=missing-pagination@v1.0 defects=0}
func missingPaginationCompliant() {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		log.Printf("error: %v", err)
		return
	}

	client := s3.NewFromConfig(cfg)

	params := &s3.ListObjectsV2Input{
		Bucket: aws.String("my-bucket"),
	}

	// Compliant: `NewListObjectsV2Paginator` is used.
	paginator := s3.NewListObjectsV2Paginator(client, params, func(o *s3.ListObjectsV2PaginatorOptions) {
		o.Limit = 10
	})

	for paginator.HasMorePages() {
		output, err := paginator.NextPage(context.TODO())
		if err != nil {
			log.Printf("error: %v", err)
			return
		}
		fmt.Println(output)
	}
}

// {/fact}
