#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=aws-strong-password-policy-cdk@v1.0 defects=0}
from aws_cdk.aws_cognito import UserPool,PasswordPolicy 
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk import (
    aws_cognito as cognito
    )

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id) 
        
        # Compliant: Password polciy applied making it secure
        UserPool(Stack, 'rUserPool',
            password_policy=PasswordPolicy(
            minLength= 8,
            require_uppercase= True,
            require_digits= True,
            require_symbols= True,
            ),
        )
        # {/fact}