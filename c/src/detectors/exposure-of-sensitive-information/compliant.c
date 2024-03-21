/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=exposure-of-sensitive-information@v1.0 defects=0}
int exposureofSensitiveInformationCompliant()
{
    // Compliant: https is used for secured url
    char* https_url = "https://example.com";
}

// {/fact}