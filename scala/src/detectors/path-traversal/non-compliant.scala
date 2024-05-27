/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


class PathTraversalNoncompliant {
    // {fact rule=path-traversal@v1.0 defects=1}
    def nonCompliant(value:String) = Action {
        if (!Files.exists(Paths.get("public/lists/" + value))) {
            NotFound("File not found")
        } else {
            // Noncompliant: The code constructs a file path using user-controlled input without proper sanitization, which can lead to path traversal vulnerabilities.
            val result = Source.fromFile("public/lists/" + value).getLines().mkString // Weak point
            Ok(result)
        }
    }
    // {/fact}
}