
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-adherence-coding-standards-cdk@v1.0 defects=1}
import { CfnDBCluster, CfnDBInstance } from 'aws-cdk-lib/aws-neptune';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Multi-AZ deployment configuration have not used.
        new CfnDBCluster(Stack, 'rDatabaseCluster', {
            availabilityZone: ['us-east-1a'],
            dbSubnetGroupName: 'foo',
            iamAuthEnabled: true
        });
    }
}

// {/fact}

// {fact rule=improper-adherence-coding-standards-cdk@v1.0 defects=0}
import { CfnDBCluster, CfnDBInstance } from 'aws-cdk-lib/aws-neptune';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Multi-AZ deployment configuration have used.
        new CfnDBCluster(Stack, 'rDatabaseCluster', {
            availabilityZone: ['us-east-1a', 'us-east-1b'],
            dbSubnetGroupName: 'foo',
            iamAuthEnabled:true
        });
    }
}

// {/fact}