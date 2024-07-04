#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=missing-encryption-of-sensitive-data-cdk@v1.0 defects=0}
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

    # Compliant: Notifications set for all events
    negTopic = sns.Topic(self, 'rAsgTopic')
    autoscaling.AutoScalingGroup(self, 'rAsg2', 
      vpc = ec2.Vpc(self, 'rVpc2'),
      instance_type = ec2.InstanceType.of(ec2.InstanceClass.MEMORY5),
      machine_image =  ec2.MachineImage.latestAmazonLinux(),
      notifications = [
        autoscaling.NotificationConfiguration(
          topic =  negTopic,
          scaling_events = autoscaling.ScalingEvents.ALL
        ) 
      ],
    )
    # {/fact}