package main

import (
	"context"
	"fmt"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/service/sns"
)

// {fact rule=aws-unchecked-batch-failures@v1.0 defects=1}
func awsUncheckedBatchFailuresNoncompliant(topicARN string, cfg aws.Config) {
	client := sns.NewFromConfig(cfg)

	output, _ := client.PublishBatch(context.TODO(), &sns.PublishBatchInput{
		TopicArn: &topicARN,
	})

	// Noncompliant: Batch operation is performed without handling error.
	fmt.Println(output)
}
// {/fact}

// {fact rule=aws-unchecked-batch-failures@v1.0 defects=0}
func awsUncheckedBatchFailuresCompliant(topicARN string, cfg aws.Config) {
	client := sns.NewFromConfig(cfg)

	output, err := client.PublishBatch(context.TODO(), &sns.PublishBatchInput{
		TopicArn: &topicARN,
	})

	// Compliant: Batch operation is performed with handling error.
	if err != nil {
		fmt.Println("Error publishing batch:", err)
		return
	}

	fmt.Println(output)
}
// {/fact}
