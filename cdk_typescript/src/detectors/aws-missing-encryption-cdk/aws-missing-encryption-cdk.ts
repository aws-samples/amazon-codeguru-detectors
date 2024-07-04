
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=aws-missing-encryption-cdk@v1.0 defects=1}
import * as cdk from '@aws-cdk/core';
import * as sqs from '@aws-cdk/aws-sqs';

export class Stack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Noncompliant: Queue is not encrypted
    const unencryptedQueue = new sqs.Queue(this, 'unecryptedQueue1')
   
  }
}
// {/fact}
    
// {fact rule=aws-missing-encryption-cdk@v1.0 defects=0}
import * as cdk from '@aws-cdk/core';
import * as sqs from '@aws-cdk/aws-sqs';
import { Queue, QueueEncryption } from '@aws-cdk/aws-sqs';

export class Stack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    // Compliant: Queue is encrypted
    const encryptedQueue = new sqs.Queue(this, 'encryptedQueue', {
        encryption: sqs.QueueEncryption.KMS_MANAGED
    })
   
  }
}
// {/fact}