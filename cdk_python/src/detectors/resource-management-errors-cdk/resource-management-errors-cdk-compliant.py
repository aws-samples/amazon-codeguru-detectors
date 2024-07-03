#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=resource-management-errors-cdk@v1.0 defects=0}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ec2 import Instance,InstanceClass,InstanceType,MachineImage,Vpc
from aws_cdk.aws_autoscaling import AutoScalingGroup,Monitoring
from aws_cdk import aws_ec2 as ec2
from aws_cdk import aws_autoscaling as autoscaling


class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Detailed monitoring enabled
        autoscaling.AutoScalingGroup(Stack, 'rAsg', 
            vpc= Vpc(Stack, 'rVpc2'),
            instance_type= InstanceType(InstanceClass.T3),
            machine_image= MachineImage.latestAmazonLinux2(),
            instance_monitoring= Monitoring.DETAILED,
        )
        # {/fact}
