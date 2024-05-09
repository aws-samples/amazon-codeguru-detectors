/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=exposure-of-sensitive-information-cdk@v1.0 defects=1}
import * as cdk from '@aws-cdk/core'
import { CfnSecurityGroupIngress, } from 'aws-cdk-lib/aws-ec2'
import {Stack} from 'aws-cdk-lib/core'

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Noncompliant: 0.0.0.0/0 range is used
        new CfnSecurityGroupIngress(Stack, 'rIngress', {
            ipProtocol: 'tcp',
            cidrIp: '0.0.0.0/0',
        })
    }
}
// {/fact}

// {fact rule=exposure-of-sensitive-information-cdk@v1.0 defects=0}
import * as cdk from '@aws-cdk/core'
import { CfnSecurityGroupIngress, } from 'aws-cdk-lib/aws-ec2'
import {Stack} from 'aws-cdk-lib/core'

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Compliant: 0.0.0.0/0 range is not used
        new CfnSecurityGroupIngress(Stack, 'rIngress', {
            ipProtocol: 'tcp',
            cidrIp: '1.2.3.4/32',
            })
    }
}
// {/fact}
