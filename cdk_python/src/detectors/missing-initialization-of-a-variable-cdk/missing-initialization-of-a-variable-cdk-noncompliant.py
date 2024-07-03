#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=missing-initialization-of-a-variable-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk.aws_redshift import CfnCluster
from aws_cdk import aws_redshift as redshift 
from aws_cdk import Aspects, Stack 

class CdkStarterself(cdk.self):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)
     
        # Noncompliant: Automated Snapshot Retention Period is not between 1 to 35.
        CfnCluster(Stack, 'rRedshiftCluster', 
            master_username= 'use_a_secret_here',
            master_user_password= 'use_a_secret_here',
            cluster_type= 'single-node',
            db_name= 'bar',
            node_type= 'ds2.xlarge',
            automated_snapshot_retention_period= 0,
            encrypted= True,
            port=42,
        )
        # {/fact }