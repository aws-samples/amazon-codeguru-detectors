/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=improper-access-control-cdk@v1.0 defects=1}
import * as cdk from '@aws-cdk/core'
import { Repository } from 'aws-cdk-lib/aws-ecr'
import { PolicyStatement, Effect, AccountPrincipal, AccountRootPrincipal, } from 'aws-cdk-lib/aws-iam'
import { Stack } from 'aws-cdk-lib/core'


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props)

    const repo = new Repository(Stack, 'rRepo')

    // Noncompliant: '*' principals in an ECR Repository is used.
    repo.addToResourcePolicy(
        new PolicyStatement({
          effect: Effect.ALLOW,
          actions: ['*'],
          principals: [new AccountPrincipal('*'), new AccountRootPrincipal()],
        })
    )
}
// {/fact}

// {fact rule=improper-access-control-cdk@v1.0 defects=0}
import * as cdk from '@aws-cdk/core'
import { Stack } from 'aws-cdk-lib/core'


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Compliant: '*' principals in an ECR Repository is not used.
        new Repository(Stack, 'rRepo')
    }
}
// {/fact}
