
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improperly-implemented-security-check-cdk@v1.0 defects=1}
import {
    OriginSslPolicy,
    Distribution,
} from 'aws-cdk-lib/aws-cloudfront';
import { HttpOrigin } from 'aws-cdk-lib/aws-cloudfront-origins';
import {Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: `OriginSslPolicy.TLS_V1` is not a secure policy.
        new Distribution(Stack, 'rDistribution', {
            defaultBehavior: {
                origin: new HttpOrigin('foo.bar.com', {
                    originSslProtocols: [
                        OriginSslPolicy.TLS_V1,
                        OriginSslPolicy.TLS_V1_1,
                    ],
                }),
            },
        });
    }
}

// {/fact}

// {fact rule=improperly-implemented-security-check-cdk@v1.0 defects=0}
import {
    OriginSslPolicy,
    Distribution,
} from 'aws-cdk-lib/aws-cloudfront';
import {Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: `OriginSslPolicy.TLS_V1_2` is a secure policy.
        new Distribution(Stack, 'rDistribution2', {
            defaultBehavior: {
                origin: new HttpOrigin('foo.bar.com', {
                    originSslProtocols: [OriginSslPolicy.TLS_V1_2],
                }),
            },
        });
    }
}

// {/fact}