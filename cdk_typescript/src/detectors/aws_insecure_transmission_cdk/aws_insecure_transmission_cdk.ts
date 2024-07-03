/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=aws-insecure-transmission-cdk@v1.0 defects=1}
import * as s3 from "@aws-cdk/aws-s3"
import * as cdk from "@aws-cdk/core"


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) { 
        super(scope, id, props);

        // Noncompliant: SSL configuration missing
        const bucket = new s3.Bucket(this, "s3-bucket")
    }
}
// {/fact}

// {fact rule=aws-insecure-transmission-cdk@v1.0 defects=0}
import * as s3 from "@aws-cdk/aws-s3"
import * as cdk from "@aws-cdk/core"


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) { 
        super(scope, id, props);

        // Compliant: SSL configuration present
        const bucket = new s3.Bucket(this, "s3-bucket", { enforceSSL: true });
    }
}
// {/fact}
