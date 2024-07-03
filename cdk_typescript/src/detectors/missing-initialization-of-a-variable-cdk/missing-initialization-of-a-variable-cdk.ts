
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-initialization-of-a-variable-cdk@v1.0 defects=1}
import { CfnCluster, CfnClusterParameterGroup } from 'aws-cdk-lib/aws-redshift';
import { Aspects, Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: The Redshift cluster hasn't a retention period for automated snapshots configured.
        new CfnCluster(Stack, 'rRedshiftCluster', {
            masterUsername: 'use_a_secret_here',
            masterUserPassword: 'use_a_secret_here',
            clusterType: 'single-node',
            dbName: 'bar',
            nodeType: 'ds2.xlarge',
            automatedSnapshotRetentionPeriod: 0,
            encrypted: true,
            port:42,
        });
    }
}
// {/fact}

// {fact rule=missing-initialization-of-a-variable-cdk@v1.0 defects=0}
import { CfnCluster, CfnClusterParameterGroup } from 'aws-cdk-lib/aws-redshift';
import { Aspects, Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: The Redshift cluster has a retention period for automated snapshots configured.
        new CfnCluster(Stack, 'rRedshiftCluster', {
            masterUsername: 'use_a_secret_here',
            masterUserPassword: 'use_a_secret_here',
            clusterType: 'single-node',
            dbName: 'bar',
            nodeType: 'ds2.xlarge',
            automatedSnapshotRetentionPeriod: 1,
            encrypted: true,
            port:42,
        });
    }
}
// {/fact}