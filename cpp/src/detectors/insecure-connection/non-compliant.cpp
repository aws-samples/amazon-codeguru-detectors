/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-connection@v1.0 defects=1}
#include <stdio.h>

void insecureConnectionNoncompliant() {
    char* url = "www.google.com";

    // Noncompliant: Opening a connection to a URL using insecure HTTP enforces SSL.
    someApi(url, "http://example.com");
}
// {/fact}