#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=aws-strong-password-policy-cdk@v1.0 defects=1}
from aws_cdk.aws_cognito import UserPool,PasswordPolicy 
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk import (
    aws_cognito as cognito
    )

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 
        
        # Noncompliant: No password policy specified making it insecure
        UserPool(Stack, 'rUserPool')
        # {/fact}