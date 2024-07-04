#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

#{fact rule=missing-encryption-of-sensitive-data-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_autoscaling import AutoScalingGroup, ScalingEvents,ScalingEvent, NotificationConfiguration
from aws_cdk.aws_sns import Topic
from aws_cdk.aws_ec2 import InstanceClass,InstanceType, MachineImage, Vpc
from aws_cdk import aws_ec2 as ec2
from aws_cdk import aws_sns as sns
from aws_cdk import aws_autoscaling as autoscaling

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Noncompliant: Notifications set only for errors
    AutoScalingGroup(self, 'rAsg', 
      vpc = Vpc(self, 'rVpc'),
      instance_type = InstanceType.of(InstanceClass.MEMORY5),
      machine_image =  MachineImage.latestAmazonLinux(),
      notifications = [
        NotificationConfiguration(
          topic =  Topic(self, 'rAsgTopic'),
          scaling_events = ScalingEvents.ERRORS
        ) 
      ]
    )
    # {/fact}