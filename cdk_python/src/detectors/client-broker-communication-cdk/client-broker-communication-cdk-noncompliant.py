#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

#{fact rule=client-broker-communication-cdk@v1.0 defects=1}
import aws_cdk as cdk
from aws_cdk import Stack
from aws_cdk.aws_msk import CfnCluster
from aws_cdk import aws_msk as msk 

class CdkStarterself(cdk.self):
  def __init__(self, scope: cdk.App, id: str):
    super(scope, id)

    # Noncompliant: Allows clients to communicate using both TLS-encrypted and unencrypted (plaintext) connections.
    CfnCluster(self, 'rMsk', 
      cluster_name= 'foo',
      kafka_version= '2.8.0',
      number_of_broker_nodes= 42,
      encryption_info= CfnCluster.EncryptionInfoProperty(
        encryption_at_rest=CfnCluster.EncryptionAtRestProperty(
            data_volume_kms_key_id="dataVolumeKmsKeyId"
        ),
        encryption_in_transit=CfnCluster.EncryptionInTransitProperty(
            client_broker='TLS_PLAINTEXT'
        ),
        logging_info= CfnCluster.LoggingInfoProperty(
	         broker_logs= CfnCluster.BrokerLogsProperty(
	           firehose=CfnCluster.FirehoseProperty(
	               enabled=True,
	               delivery_stream="deliveryStream"
	           ),
	        ),
        )
      )
    )
    # {/fact}