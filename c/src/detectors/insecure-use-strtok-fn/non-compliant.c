/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-strtok-fn@v1.0 defects=1}
#include <string.h>

// Noncompliant: Insecure - Alter static literal
void insecureUseStrtokNonCompliant() {
    char *static_str = "message,token";
    strtok(static_str, ",");
}
// {/fact}