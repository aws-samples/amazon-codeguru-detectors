#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=incomplete-configuration-cdk@v1.0 defects=1}
from aws_cdk import core as cdk 
from aws_cdk import aws_rds as rds
from aws_cdk.aws_rds import DatabaseInstance, DatabaseInstanceEngine, PostgresEngineVersion
from config.db_config import DBConfig
import aws_cdk as cdk


class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
      super(scope, id)
      
      # Noncompliant: Disabled multi-AZ support for the RDS database instance.
      DatabaseInstance(self, "rDbInstance", 
      engine = DatabaseInstanceEngine.POSTGRES,
      vpc = vpc,
      multi_az = False,
      )
      # {/fact}