#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=missing-authorization-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack,Duration,SecretValue
from aws_cdk.aws_docdb import DatabaseCluster
from aws_cdk.aws_docdb import Login,BackupProps
from aws_cdk import aws_docdb as DOCDB

from aws_cdk.aws_ec2 import InstanceType,InstanceClass,InstanceSize,Vpc

class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: No backup retention plan
        DatabaseCluster(Stack, 'rDatabaseCluster',
            instance_type= InstanceType.of(InstanceClass.R5, InstanceSize.LARGE),
            vpc= Vpc(Stack, 'rVpc'),
            master_user= Login(
            username= 'foo',
            password= 'bar',
            ),
        )
        #{/fact}