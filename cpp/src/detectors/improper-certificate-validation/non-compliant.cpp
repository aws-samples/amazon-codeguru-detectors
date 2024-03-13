/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-certificate-validation@v1.0 defects=1}
#include <iostream>

int improperCertificateValidationNoncompliant() {
    char* ssl;
    char* cert;
    // Noncompliant: "SSL_get_verify_result" is never called
    cert = SSL_get_peer_certificate(ssl);

    return 0;
}
// {/fact}