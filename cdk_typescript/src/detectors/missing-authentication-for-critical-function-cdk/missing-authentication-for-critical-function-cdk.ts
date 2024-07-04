/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=missing-authentication-for-critical-function-cdk@v1.0 defects=1}
import * as s3 from '@aws-cdk/aws-s3'
import * as cdk from '@aws-cdk/core'
import * as codebuild from '@aws-cdk/aws-codebuild'

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props)

    // Noncompliant: Public project
    const publicProject1 = new codebuild.Project(this, 'publicProject', {badge: true})
}
// {/fact}
}

// {fact rule=missing-authentication-for-critical-function-cdk@v1.0 defects=0}
import * as s3 from '@aws-cdk/aws-s3'
import * as cdk from '@aws-cdk/core'
import * as codebuild from '@aws-cdk/aws-codebuild'

export class CdkStarterStack extends cdk.Stack {
    constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props)
    const bucket = new s3.Bucket()
    // Compliant: Private project
    const privateProject1 = codebuild.Project(this, 'privateProject1', {
          source: codebuild.Source.s3({
          bucket: bucket,
          path: 'path/to/file.zip',
        })
    })

}
}
// {/fact}