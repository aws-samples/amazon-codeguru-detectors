package main

import (
	"github.com/aws/aws-sdk-go/aws"
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/aws-sdk-go/service/s3"
	"log"
	"os"
)

const (
	awsRegion           = "your-aws-region"
	bucketName          = "your-bucket-name"
	objectKey           = "your-object-key"
	expectedBucketOwner = "expected-bucket-owner-id"
)

// {fact rule=s3-verify-bucket-owner@v1.0 defects=1}
func s3VerifyBucketOwnerNoncompliant() {
	fileName := "YOUR_PATH"
	sess, err := session.NewSession(&aws.Config{
		Region: aws.String(awsRegion),
	})
	if err != nil {
		log.Fatal("Error:", err)
		return
	}
	s3Client := s3.New(sess)
	file, err := os.Open(fileName)
	if err != nil {
		log.Printf("Couldn't open file %v to upload. Error: %v\n", fileName, err)
	}
	defer file.Close()
	// Noncompliant: `ExpectedBucketOwner` or `ExpectedSourceBucketOwner` argument is missing.
	_, err = s3Client.PutObject(&s3.PutObjectInput{
		Bucket: aws.String(bucketName),
		Key:    aws.String(objectKey),
		Body:   file,
	})
	if err != nil {
		log.Printf("Couldn't upload file %v to %v:%v. Error: %v\n", fileName, bucketName, objectKey, err)
	}
}

// {/fact}

// {fact rule=s3-verify-bucket-owner@v1.0 defects=0}
func s3VerifyBucketOwnerCompliant() {
	fileName := "YOUR_PATH"
	sess, err := session.NewSession(&aws.Config{
		Region: aws.String(awsRegion),
	})
	if err != nil {
		log.Fatal("Error:", err)
		return
	}
	s3Client := s3.New(sess)
	file, err := os.Open(fileName)
	if err != nil {
		log.Printf("Couldn't open file %v to upload. Error: %v\n", fileName, err)
	}
	defer file.Close()
	// Compliant: `ExpectedBucketOwner` is present.
	_, err = s3Client.PutObject(&s3.PutObjectInput{
		Bucket:              aws.String(bucketName),
		Key:                 aws.String(objectKey),
		Body:                file,
		ExpectedBucketOwner: aws.String(expectedBucketOwner),
	})
	if err != nil {
		log.Printf("Couldn't upload file %v to %v:%v. Error: %v\n", fileName, bucketName, objectKey, err)
	}
}

// {/fact}
