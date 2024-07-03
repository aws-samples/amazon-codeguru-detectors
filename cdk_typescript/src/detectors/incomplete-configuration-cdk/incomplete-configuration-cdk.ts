
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incomplete-configuration-cdk@v1.0 defects=1}
import {
    CfnCacheCluster,
    CfnReplicationGroup,
} from 'aws-cdk-lib/aws-elasticache';
import * as cdk from 'aws-cdk-lib';

import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: ElastiCache Redis cluster is not deployed in a Multi-AZ configuration.
        new CfnReplicationGroup(Stack, 'rRedisGroup', {
            cacheNodeType: 'cache.t3.micro',
            engine: 'redis',
            replicationGroupDescription: 'lorem ipsum dolor sit amet',
        });
        
    }
}
// {/fact}

// {fact rule=incomplete-configuration-cdk@v1.0 defects=0}
import {
    CfnCacheCluster,
    CfnReplicationGroup,
} from 'aws-cdk-lib/aws-elasticache';
import * as cdk from 'aws-cdk-lib';

import { Stack } from "aws-cdk-lib/core";

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: ElastiCache Redis cluster is deployed in a Multi-AZ configuration.
        new CfnReplicationGroup(Stack, 'rRedisGroup', {
            cacheNodeType: 'cache.t3.micro',
            engine: 'redis',
            replicationGroupDescription: 'lorem ipsum dolor sit amet',
            cacheSubnetGroupName: 'lorem',
            multiAzEnabled: true,
        });

    }
}

// {/fact}