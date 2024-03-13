/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-connection@v1.0 defects=0}
#include <stdio.h>

void insecureConnectionCompliant() {
    char* url = "www.google.com";

    // Compliant: Opening a connection to a URL using secure HTTPS enforces SSL.
    someApi(url, "https://example.com");
}
// {/fact}