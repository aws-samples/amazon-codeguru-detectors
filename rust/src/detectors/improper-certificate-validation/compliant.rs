/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-certificate-validation@v1.0 defects=0}
// Compliant: ssl verification is enabled
use openssl::ssl::{SslMethod, SslConnectorBuilder, SSL_VERIFY_NONE};
let mut connector = SslConnectorBuilder::new(SslMethod::tls()).unwrap();
connector.builder_mut().set_verify(SSL_VERIFY_PEER);
// {/fact}