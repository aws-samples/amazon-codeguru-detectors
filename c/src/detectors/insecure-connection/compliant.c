/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-connection@v1.0 defects=0}

void insecureConnectionCompliant() {
    // Compliant: Opening a connection to a URL using HTTPS enforces SSL.
    openUrl("https://example.com"); 
}

// {/fact}