/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-strtok-fn@v1.0 defects=0}
#include <string.h>

// Compliant: Secure - Copy first
int insecureUseStrtokCompliant() {
  char *static_str = "message,token";
  char copy[128];
  strsep_s(&copy, ",", 128);
}
// {/fact}