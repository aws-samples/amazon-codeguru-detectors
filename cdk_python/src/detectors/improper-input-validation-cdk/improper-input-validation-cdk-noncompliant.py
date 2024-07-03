#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=improper-input-validation-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import aws_apigateway as apigateway
from aws_cdk.aws_apigateway import CfnRequestValidator, RestApi

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
      super(scope, id)

      # Noncompliant: Request validation not enabled
      RestApi(self, 'RestApi').root.add_method('ANY')
      # {/fact}