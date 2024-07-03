#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=insufficiently-protected-credentials-cdk@v1.0 defects=0} 
import aws_cdk as cdk
from aws_cdk import aws_docdb as docdb
from aws_cdk import aws_ec2 as ec2
from aws_cdk.aws_docdb import DatabaseCluster, Login
from aws_cdk.aws_ec2 import  InstanceType, InstanceClass, InstanceSize, Vpc

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: Secret manager used to store credentials
    docdb.DatabaseCluster(self, "DatabaseCluster",
        instance_type=ec2.InstanceType.of(ec2.InstanceClass.R5, ec2.InstanceSize.LARGE),
        vpc=ec2.Vpc(self, "Vpc"),
        master_user=docdb.Login(
            username=SecretValue.secrets_manager("foo").to_string(),
            password=SecretValue.secrets_manager("bar")
        )
    )
    # {/fact}