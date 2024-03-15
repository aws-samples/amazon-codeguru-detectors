/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-certificate-validation@v1.0 defects=0}
#include <iostream>

int improperCertificateValidationCompliant() {
    char* ssl;
    char* cert;
    // Compliant: "SSL_get_verify_result" is called and validated
    cert = SSL_get_peer_certificate(ssl);

    int result = SSL_get_verify_result(ssl);

    if (result != X509_V_OK) {
        printf("Failed to verify server certificate");
        return 1;
    }
}
// {/fact}