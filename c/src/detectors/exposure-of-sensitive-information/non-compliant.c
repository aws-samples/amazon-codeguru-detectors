/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=exposure-of-sensitive-information@v1.0 defects=1}

int exposureofSensitiveInformationNonCompliant()
{
    // Noncompliant: insecure protocal is used
    char* ftp_url = "ftp://anonymous@example.com";
    
}

// {/fact}