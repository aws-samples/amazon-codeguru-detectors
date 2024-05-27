/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import java.util.Arrays

class OsCommandInjectionNoncompliant {
    // {fact rule=os-command-injection@v1.0 defects=1}
    def nonCompliant(command: String, arg1: String) = {
        import sys.process._
        // Noncompliant: This code is vulnerable to command injection as 'command' is constructed from user input without proper validation or sanitation.
        Seq(command, arg1).!
    }
    // {/fact}
}