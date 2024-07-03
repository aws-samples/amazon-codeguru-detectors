#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=omission-of-security-relevant-information-cdk@v1.0 defects=0}
from aws_cdk.aws_docdb import CfnDBCluster
from aws_cdk import Aspects, Duration, SecretValue,Stack 
import aws_cdk as cdk
from aws_cdk import (aws_docdb as docdb)

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
      super(scope, id)     
      
      # Compliant: Necessary log exports specified
      docdb.CfnDBCluster(Stack, 'rDatabaseCluster', 
        master_username= SecretValue.secrets_manager('foo'),
        master_user_password= SecretValue.secrets_manager('bar'),
        enable_cloudwatch_logs_exports= [
          'authenticate',
          'createIndex',
          'dropCollection',
        ],
      )
      #{/fact}
