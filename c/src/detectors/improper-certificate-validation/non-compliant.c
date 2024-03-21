/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-certificate-validation@v1.0 defects=1}
#include <stdio.h>

int improperCertificateValidationNonCompliant() {
    char* ssl;
    char* cert;
    // Noncompliant: Missing verification
    cert = SSL_get_peer_certificate(ssl); 

    return 0;
}
// {/fact}