/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

class ImproperHandlingOfUnicodeEncodingNoncompliant {

    // {fact rule=improper-handling-of-unicode-encoding@v1.0 defects=1}
    def nonCompliant(s: String) = {
        // Noncompliant: Uses improper Unicode normalization method.
        s.toUpperCase().equals("TEST")
    }
    // {/fact}
}