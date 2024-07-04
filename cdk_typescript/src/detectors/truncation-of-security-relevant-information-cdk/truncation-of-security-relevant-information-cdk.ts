
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=truncation-of-security-relevant-information-cdk@v1.0 defects=1}
import {
    CfnDBInstance
} from 'aws-cdk-lib/aws-rds';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Noncompliant: The value of `backupRetentionPeriod` is less than 1.
        new CfnDBInstance(Stack, 'rDbInstance', {
            dbInstanceClass: 'db.t3.micro',
            backupRetentionPeriod: 0,
        });
    }
}
// {/fact}

// {fact rule=truncation-of-security-relevant-information-cdk@v1.0 defects=0}
import {
    CfnDBInstance
} from 'aws-cdk-lib/aws-rds';
import { Stack } from 'aws-cdk-lib/core';
import * as cdk from 'aws-cdk-lib';

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);
        // Compliant: Default value value for backup_retention_period is 1.
        new CfnDBInstance(Stack, 'rDbInstance', {
            dbInstanceClass: 'db.t3.micro',
        });
    }
}
// {/fact}