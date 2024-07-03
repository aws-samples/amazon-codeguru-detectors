#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=improperly-implemented-security-check-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_cloudfront import Distribution, OriginProtocolPolicy, OriginSslPolicy  
from aws_cdk.aws_s3 import Bucket
from aws_cdk.aws_cloudfront_origins import HttpOrigin, S3Origin
from aws_cdk import aws_cloudfront as cloudfront
from aws_cdk import aws_cloudfront_origins as cloudfront_origins

class CdkStarterStack(core.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Allows unencrypted HTTP connections between viewers and the CloudFront distribution
        Distribution(
            self, "Distribution",
            default_behavior=BehaviorOptions(
                origin=HttpOrigin(
                    "foo.bar.com",
                    protocol_policy=[
                        OriginProtocolPolicy.MATCH_VIEWER
                    ]
                )
            )
        )
        # {/fact}