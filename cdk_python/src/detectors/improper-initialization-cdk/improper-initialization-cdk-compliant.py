#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

#{fact rule=improper-initialization-cdk@v1.0 defects=0}
from aws_cdk.aws_ecs import TaskDefinition, Compatibility, ContainerImage
from aws_cdk import Stack 
import aws_cdk as cdk
from aws_cdk import (
        aws_ecs as ecs
        )

class CdkStarterStack(cdk.Stack):
    def __init__(self, scope: cdk.App, id: str):
        super(scope, id)

        # Compliant: Environment variable not used
        TaskDefinition(Stack, 'rTaskDef', 
        compatibility= Compatibility.EC2,
        ).addContainer('rContainer', 

        image= ContainerImage.fromRegistry('imageName'),
        memory_reservation_mib= 42
        )
        #{/fact}