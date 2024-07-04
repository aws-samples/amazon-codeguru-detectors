
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-handling-of-undefined-values-cdk@v1.0 defects=1}
import { CfnCluster} from 'aws-cdk-lib/aws-redshift';
import {Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Compliant: Subnet group have not specified here.
        new CfnCluster(Stack, 'rRedshiftCluster', {
            masterUsername: 'use_a_secret_here',
            masterUserPassword: os.environ.get('PASSWORD'),
            clusterType: 'single-node',
            dbName: 'bar',
            nodeType: 'ds2.xlarge',
            encrypted: true,
            port: 42,
        });
    }
}

// {/fact}

// {fact rule=improper-handling-of-undefined-values-cdk@v1.0 defects=0}
import { CfnCluster} from 'aws-cdk-lib/aws-redshift';
import {Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Subnet group have specified here.
        new CfnCluster(Stack, 'rRedshiftCluster', {
            masterUsername: 'use_a_secret_here',
            masterUserPassword: os.environ.get('PASSWORD'),
            clusterType: 'single-node',
            dbName: 'bar',
            nodeType: 'ds2.xlarge',
            clusterSubnetGroupName: 'foo',
            encrypted: true,
            port:42,
        });
    }
}


// {/fact}