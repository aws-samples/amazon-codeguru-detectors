
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=resource-management-errors-cdk@v1.0 defects=1}
import {  CfnDomain as LegacyCfnDomain } from 'aws-cdk-lib/aws-elasticsearch';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: `vpcOptions` is not enabled.
        new LegacyCfnDomain(Stack, 'Domain', {});
    }
}
// {/fact}

// {fact rule=resource-management-errors-cdk@v1.0 defects=0}
import {  CfnDomain as LegacyCfnDomain } from 'aws-cdk-lib/aws-elasticsearch';
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: `vpcOptions` is enabled.
        new LegacyCfnDomain(Stack, 'Domain', {
            vpcOptions: {
                subnetIds: ['mycoolsubnet'],
            },
        });
    }
}
// {/fact}