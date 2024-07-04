
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-connection-cdk@v1.0 defects=1}
import { CfnDataSource } from 'aws-cdk-lib/aws-quicksight';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib/core';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: `disableSsl` is set to `true`.
        new CfnDataSource(Stack, 'rDashboard', {
            sslProperties: {disableSsl: true},
        });
    }
}
// {/fact}

// {fact rule=insecure-connection-cdk@v1.0 defects=0}
import { CfnDataSource } from 'aws-cdk-lib/aws-quicksight';
import * as cdk from 'aws-cdk-lib';
import { Stack } from 'aws-cdk-lib/core';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: `disableSsl` is set to `false`.
        new CfnDataSource(Stack, 'rDashboard', {
            sslProperties: { disableSsl: false },
        });
    }
}

// {/fact}