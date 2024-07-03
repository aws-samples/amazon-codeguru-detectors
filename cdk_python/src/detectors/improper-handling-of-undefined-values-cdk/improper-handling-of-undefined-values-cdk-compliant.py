#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=improper-handling-of-undefined-values-cdk@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_redshift import CfnCluster
from aws_cdk import aws_redshift as redshift

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: Cluster specified making it secure
    redshift.CfnCluster(self, 'rRedshiftCluster', 
      master_username= 'use_a_secret_here',
      master_user_password= 'use_a_secret_here',
      cluster_type= 'single-node',
      db_name= 'bar',
      node_type= 'ds2.xlarge',
      cluster_subnet_group_name= 'foo',
      encrypted= True,
	  port=42,
    )
    # {/fact}