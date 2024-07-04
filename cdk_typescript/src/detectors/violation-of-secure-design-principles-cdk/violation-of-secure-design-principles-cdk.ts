
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=violation-of-secure-design-principles-cdk@v1.0 defects=1}
import {
    UserPool,
    CfnUserPool,
} from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: AdvancedSecurityMode not set to ENFORCED.
        new UserPool(Stack, 'rUserPool');
    }
}
// {/fact}

// {fact rule=violation-of-secure-design-principles-cdk@v1.0 defects=0}
import {
    UserPool,
    CfnUserPool,
} from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: AdvancedSecurityMode set to ENFORCED.
        new CfnUserPool(Stack, 'rUserPool', {
            userPoolAddOns: { advancedSecurityMode: 'ENFORCED' },
        });

    }
}
// {/fact}