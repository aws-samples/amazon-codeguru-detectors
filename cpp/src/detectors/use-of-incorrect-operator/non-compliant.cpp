/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-of-incorrect-operator@v1.0 defects=1}

void useOfIncorrectOperatorNoncompliant() {
    char *src, *dst;
    int left;

    while (*src && left) {
        *dst++=*src++;
        // Noncompliant: Used assignment instead of equality operator.
        if (left = 0) {
                die("badlen");
        }
        left--;
    }
}
// {/fact}