
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-authentication-cdk@v1.0 defects=1}
import {
    CfnIdentityPool
} from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: `allowUnauthenticatedIdentities` is set to `true`.
        new CfnIdentityPool(Stack, 'rIdentityPool', {
            allowUnauthenticatedIdentities: true,
        });
        
    }
}

// {/fact}

// {fact rule=improper-authentication-cdk@v1.0 defects=0}
import {
    CfnIdentityPool
} from 'aws-cdk-lib/aws-cognito';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: `allowUnauthenticatedIdentities` is set to `false`.
        new CfnIdentityPool(Stack, 'rIdentityPool', {
            allowUnauthenticatedIdentities: false,
        });
    }
}

// {/fact}