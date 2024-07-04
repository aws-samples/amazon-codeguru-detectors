/* Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=aws-kmskey-encryption-cdk@v1.0 defects=1}
import { BuildSpec, Project } from "aws-cdk-lib/aws-codebuild";
import * as cdk from "@aws-cdk/core";
import { Stack } from "aws-cdk-lib/core";


export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

            //Noncompliant: KMS key encryption configuration is not present
            new Project(Stack, "rBuildProject", {
                                buildSpec: BuildSpec.fromObjectToYaml(
                                    {
                                      version: 0.2,
                                      phases: {
                                        build: { commands: ['echo "foo"'], } }
                                    }
                                )
            });
    }
}
// {/fact}
  
// {fact rule=aws-kmskey-encryption-cdk@v1.0 defects=0}
import { BuildSpec, Project } from "aws-cdk-lib/aws-codebuild";
import * as cdk from "@aws-cdk/core";
import { Stack } from "aws-cdk-lib/core";
import { Key } from "aws-cdk-lib/aws-kms";

  
export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
        super(scope, id, props);

            //Compliant: KMS key encryption configuration is present
            new Project(Stack, "rBuildProject", {
                                buildSpec: BuildSpec.fromObjectToYaml(
                                    {
                                      version: 0.2,
                                      phases: {
                                          build: { commands: ['echo "foo"'] }
                                      }
                                    }),
                                encryptionKey: new Key(Stack, "rBuildKey")

            });
    }
}
// {/fact}
