#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0
#  
# {fact rule=improper-access-control-cdk@v1.0 defects=1}
import aws_cdk
from aws_cdk.aws_ecr import Repository
from aws_cdk.aws_iam import PolicyStatement
from aws_cdk.aws_iam import Effect
from aws_cdk.aws_iam import AccountPrincipal
from aws_cdk.aws_iam import AccountRootPrincipal
from aws_cdk import Stack


class ECROpenAccess:
    def __init__(self):

        # Noncompliant: Granting broad public access to repo
        repo = Repository(Stack, 'rRepo')
        repo.add_to_resource_policy(PolicyStatement(effect=Effect.ALLOW, actions=['*'], principals=[AccountPrincipal('*'), AccountRootPrincipal()]))
        # {/fact}
