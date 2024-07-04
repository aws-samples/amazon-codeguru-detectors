#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=resource-management-errors-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_ec2 import Instance,InstanceClass,InstanceType,MachineImage,Vpc
from aws_cdk.aws_autoscaling import AutoScalingGroup,Monitoring
from aws_cdk import aws_ec2 as ec2
from aws_cdk import aws_autoscaling as autoscaling


class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Noncompliant: Detailed monitoring not enabled
        Instance(Stack, 'rInstance', 
            vpc= Vpc(Stack, 'rVpc'),
            instance_type= InstanceType.of(InstanceClass.T3),
            machine_image= MachineImage.latest_amazon_linux2(),
        )
        # {/fact}