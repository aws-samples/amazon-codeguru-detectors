
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insufficiently-protected-credentials-cdk@v1.0 defects=1}
import { DatabaseCluster } from "aws-cdk-lib/aws-docdb";
import {
    InstanceType,
    InstanceClass,
    InstanceSize,
    Vpc,
} from "aws-cdk-lib/aws-ec2";
import { SecretValue } from "aws-cdk-lib/core";
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        
        new DatabaseCluster(Stack, "rDatabaseCluster", {
            instanceType: InstanceType.of(InstanceClass.R5, InstanceSize.LARGE),
            vpc: new Vpc(Stack, "rVpc"),
            // Noncompliant: Hardcoded credentials is used.
            masterUser: {
                username: "foo",
                password: SecretValue.secretsManager("bar"),
            },
        });
    }
}
// {/fact}

// {fact rule=insufficiently-protected-credentials-cdk@v1.0 defects=0}
import { DatabaseCluster } from "aws-cdk-lib/aws-docdb";
import {
    InstanceType,
    InstanceClass,
    InstanceSize,
    Vpc,
} from "aws-cdk-lib/aws-ec2";
import { SecretValue } from "aws-cdk-lib/core";
import * as cdk from 'aws-cdk-lib';
import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        new DatabaseCluster(Stack, "rDatabaseCluster", {
            instanceType: InstanceType.of(InstanceClass.R5, InstanceSize.LARGE),
            vpc: new Vpc(Stack, "rVpc"),
            // Compliant: Credentials used from secret manager.
            masterUser: {
                username: SecretValue.secretsManager("foo").toString(),
                password: SecretValue.secretsManager("bar"),
            },
        });
    }
}
// {/fact}