#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

#{fact rule=violation-of-secure-design-principles-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_cognito import UserPool,CfnUserPool, AdvancedSecurityMode
from aws_cdk import (
    aws_cognito
)

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
        
	    # Noncompliant: Advanced security mode not enabled
        UserPool(Stack, 'rUserPool')
	    # {/fact}