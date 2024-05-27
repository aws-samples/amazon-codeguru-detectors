/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

class ImproperHandlingOfUnicodeEncodingCompliant {

    // {fact rule=improper-handling-of-unicode-encoding@v1.0 defects=0}
    def compliant(s: String) = {
        val normalizedInput = Normalizer.normalize(s, Normalizer.Form.NFC)
        val normalizedTest = Normalizer.normalize("TEST", Normalizer.Form.NFC)
        // Compliant: `Normalizer.normalize` used to normalize the URI string.
        normalizedInput.toUpperCase() == normalizedTest
    }
    // {/fact}
}