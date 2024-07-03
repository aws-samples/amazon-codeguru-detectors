
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-input-validation-cdk@v1.0 defects=1}
import { Stack } from 'aws-cdk-lib';
import {
    CfnFunction,
    Runtime
} from 'aws-cdk-lib/aws-lambda';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Latest runtime version is not used.
        new CfnFunction(Stack, 'rFunction', {
            runtime: Runtime.NODEJS_16_X.toString(),
            code: {},
            role: 'somerole'
        });
    }
}

// {/fact}

// {fact rule=improper-input-validation-cdk@v1.0 defects=0}
import { Stack } from 'aws-cdk-lib';
import {
    CfnFunction,
    Runtime
} from 'aws-cdk-lib/aws-lambda';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Latest runtime version is used.
        new CfnFunction(Stack, 'rFunction', {
            runtime: getLatestRuntime('nodejs').toString(),
            code: {},
            role: 'somerole'
        });
    }
}

// {/fact}