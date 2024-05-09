/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=use-of-default-credentials-cdk@v1.0 defects=1}
import { CfnCluster } from 'aws-cdk-lib/aws-redshift';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from '@aws-cdk/core';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props)

        // Noncompliant: Default master user name is used
        new CfnCluster(Stack, 'rRedshiftCluster', {
                                        masterUsername: 'awsuser',
                                        masterUserPassword: 'use_a_secret_here',
                                        clusterType: 'single-node',
                                        dbName: 'bar',
                                        nodeType: 'ds2.xlarge'
                                    });
    }
}
// {/fact}

// {fact rule=use-of-default-credentials-cdk@v1.0 defects=0}
import { CfnCluster } from 'aws-cdk-lib/aws-redshift';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from '@aws-cdk/core';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props)

        // Compliant: Custom master user name is used
        new CfnCluster(Stack, 'rRedshiftCluster', {
                                        masterUsername: 'notawsuser',
                                        masterUserPassword: 'use_a_secret_here',
                                        clusterType: 'single-node',
                                        dbName: 'bar',
                                        nodeType: 'ds2.xlarge',
                                    });

    }
}
// {/fact}
