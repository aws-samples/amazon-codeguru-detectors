
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=aws-strong-password-policy-cdk@v1.0 defects=1}
import { UserPool } from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Userpool don't have strong password policies.
        new UserPool(Stack, 'rUserPool', {
            passwordPolicy: {
                minLength: 8,
                requireUppercase: true,
                requireDigits: true,
            },
        });
    }
}
// {/fact}

// {fact rule=aws-strong-password-policy-cdk@v1.0 defects=0}
import { UserPool } from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Userpool has strong password policies.
        new UserPool(Stack, 'rUserPool', {
            passwordPolicy: {
                minLength: 8,
                requireUppercase: true,
                requireDigits: true,
                requireSymbols: true,
            },
        });
    }
}
// {/fact}