#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=insufficient-logging-cdk@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_s3 import Bucket
from aws_cdk.aws_ec2 import Vpc
from aws_cdk.aws_elasticloadbalancing import LoadBalancer
from aws_cdk.aws_elasticloadbalancingv2 import ApplicationLoadBalancer, NetworkLoadBalancer
from aws_cdk import aws_elasticloadbalancing as elb
from aws_cdk import aws_elasticloadbalancingv2 as elbv2

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Compliant: Enabled access logging for the Elastic Load Balancer
    elb.LoadBalancer(self, 'rELB', 
      vpc =  Vpc(self, 'rVPC3'),
      access_logging_policy = elb.LoadBalancer.AccessLoggingPolicyProperty(
        s3_bucket_name = 'foo',
        enabled =  True
      )
    )
    # {/fact}