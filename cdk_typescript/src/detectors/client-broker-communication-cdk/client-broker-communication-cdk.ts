
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=client-broker-communication-cdk@v1.0 defects=1}
import { CfnCluster } from 'aws-cdk-lib/aws-msk';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: TLS client broker is not used.
        new CfnCluster(Stack, 'rMsk', {
            clusterName: 'foo',
            kafkaVersion: '2.8.0',
            brokerNodeGroupInfo: {
                clientSubnets: ['bar'],
                instanceType: 'kafka.m5.large',
            },
            numberOfBrokerNodes: 42,
            encryptionInfo: {
                encryptionInTransit: {clientBroker: 'TLS_PLAINTEXT'},
            },
        });
    }
}

// {/fact}

// {fact rule=client-broker-communication-cdk@v1.0 defects=0}
import { CfnCluster } from 'aws-cdk-lib/aws-msk';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: TLS client broker is used.
        new CfnCluster(Stack, 'rMsk', {
            clusterName: 'foo',
            kafkaVersion: '2.8.0',
            brokerNodeGroupInfo: {
                clientSubnets: ['bar'],
                instanceType: 'kafka.m5.large',
            },
            numberOfBrokerNodes: 42,
            encryptionInfo: { encryptionInTransit: { clientBroker: 'TLS' } },
        });
    }
}

// {/fact}