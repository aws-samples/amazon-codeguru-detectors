/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import java.nio.file.Path
import java.nio.file.Files
import java.nio.file.attribute.PosixFilePermission


class IncorrectPermissionAssignmentCompliant {
    // {fact rule=incorrect-permission-assignment@v1.0 defects=0}
    @throws[IOException]
    def compliant(path: Path): Unit = {
        val perms = new java.util.HashSet[PosixFilePermission]()
        // Compliant: Permissions are set to the correct values.
        perms.add(PosixFilePermission.OWNER_READ)
    }
    // {/fact}
}