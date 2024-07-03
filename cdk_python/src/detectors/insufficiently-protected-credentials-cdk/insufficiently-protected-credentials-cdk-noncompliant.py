#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=insufficiently-protected-credentials-cdk@v1.0 defects=1} 
import aws_cdk as cdk
from aws_cdk import aws_docdb as docdb
from aws_cdk import aws_ec2 as ec2
from aws_cdk.aws_docdb import DatabaseCluster, Login
from aws_cdk.aws_ec2 import  InstanceType, InstanceClass, InstanceSize, Vpc

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Noncompliant: username stored in plain-text
    DatabaseCluster(self, "DatabaseCluster",
        instance_type=InstanceType.of(InstanceClass.R5, InstanceSize.LARGE), 
        vpc=Vpc(self, "Vpc"),
        master_user=Login(username="foo", password=SecretValue.secrets_manager("bar"))
    )
    # {/fact}