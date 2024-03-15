/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-comparison@v1.0 defects=0}
#include <stdio.h>

#define X509_V_OK 1

#define X509_V_ERR_CERT_HAS_EXPIRED 1

void improperCertificateValidationCompliant() {
    char* ssl;
    // Compliant: Proper verification done
    X509 *cert = SSL_get_peer_certificate(ssl);
    if (cert) {
        int result = SSL_get_verify_result(ssl);
        if (result == X509_V_OK) {
            //...
        }
    }
}
// {/fact}