
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=omission-of-security-relevant-information-cdk@v1.0 defects=1}
import { CfnDBCluster, DatabaseCluster } from 'aws-cdk-lib/aws-docdb';
import { SecretValue, Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Document DB cluster hasn't authenticate, createIndex, and dropCollection Log Exports enabled.
        new CfnDBCluster(Stack, 'rDatabaseCluster', {
            masterUsername: SecretValue.secretsManager('foo').toString(),
            masterUserPassword: SecretValue.secretsManager('bar').toString(),
            enableCloudwatchLogsExports: ['authenticate', 'dropCollection'],
        });
    }
}
// {/fact}

// {fact rule=omission-of-security-relevant-information-cdk@v1.0 defects=0}
import { CfnDBCluster, DatabaseCluster } from 'aws-cdk-lib/aws-docdb';
import { SecretValue, Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Document DB clusters has authenticate, createIndex, and dropCollection Log Exports enabled.
        new CfnDBCluster(Stack, 'rDatabaseCluster', {
            masterUsername: SecretValue.secretsManager('foo').toString(),
            masterUserPassword: SecretValue.secretsManager('bar').toString(),
            enableCloudwatchLogsExports: [
                'authenticate',
                'createIndex',
                'dropCollection',
            ],
        });
    }
}
// {/fact}