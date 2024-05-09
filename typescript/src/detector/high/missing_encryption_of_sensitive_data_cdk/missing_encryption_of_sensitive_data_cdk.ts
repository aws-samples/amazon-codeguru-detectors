/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=missing-encryption-of-sensitive-data-cdk@v1.0 defects=1}
import {CfnCluster, CfnClusterParameterGroup} from "aws-cdk-lib/aws-redshift"
import * as cdk from "@aws-cdk/core"
import {Stack} from "aws-cdk-lib/core"


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

        // Noncompliant: encrypted property is disabled.
        new CfnCluster(Stack, "rRedshiftCluster",
            {
                masterUsername: "use_a_secret_here",
                masterUserPassword: "use_a_secret_here",
                clusterType: "single-node",
                dbName: "bar",
                nodeType: "ds2.xlarge"
            })
    }
}

// {/fact}

// {fact rule=missing-encryption-of-sensitive-data-cdk@v1.0 defects=0}
import {CfnCluster, CfnClusterParameterGroup} from "aws-cdk-lib/aws-redshift"
import * as cdk from "@aws-cdk/core"
import {Stack} from "aws-cdk-lib/core"


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props)

        // Compliant: encrypted property is true.
        new CfnCluster(Stack, "rRedshiftCluster", {
            masterUsername: "use_a_secret_here",
            masterUserPassword: "use_a_secret_here",
            clusterType: "single-node",
            dbName: "bar",
            nodeType: "ds2.xlarge",
            encrypted: true
        })
    }
}

// {/fact}
