
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-initialization-cdk@v1.0 defects=1}
import {
    TaskDefinition,
    Compatibility,
    ContainerImage
} from 'aws-cdk-lib/aws-ecs';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: Containers in ECS task definitions is directly specified environment variables.
        new TaskDefinition(Stack, 'rTaskDef', {
            compatibility: Compatibility.EC2,
        }).addContainer('rContainer', {

            image: ContainerImage.fromRegistry('imageName'),
            memoryReservationMiB: 42,
            environment: { foo: 'bar' },
        });
    }
}


// {/fact}

// {fact rule=improper-initialization-cdk@v1.0 defects=0}
import {
    TaskDefinition,
    Compatibility,
    ContainerImage
} from 'aws-cdk-lib/aws-ecs';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Containers in ECS task definitions is not directly specified environment variables.
        new TaskDefinition(Stack, 'rTaskDef', {
            compatibility: Compatibility.EC2,
        }).addContainer('rContainer', {

            image: ContainerImage.fromRegistry('imageName'),
            memoryReservationMiB: 42,
        });
    }
}


// {/fact}