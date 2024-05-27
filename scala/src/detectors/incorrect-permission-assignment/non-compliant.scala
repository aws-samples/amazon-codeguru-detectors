/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.PosixFilePermissions

class IncorrectPermissionAssignmentNoncompliant {
    // {fact rule=incorrect-permission-assignment@v1.0 defects=1}
    @throws[IOException]
    def nonCompliant(path: Nothing): Unit = {
        val perms = new java.util.HashSet[PosixFilePermission]()
        // Noncompliant: Permissions are not assigned correctly.
        val perms = PosixFilePermissions.fromString("rw-rw-rw-")
        Files.setPosixFilePermissions(path, perms)
    }
    // {/fact}
}