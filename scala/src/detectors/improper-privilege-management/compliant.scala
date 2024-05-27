/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.lang.reflect.ReflectPermission
import java.security.CodeSource
import java.security.PermissionCollection
import java.security.Policy

class ImproperPrivilegeManagementCompliant extends Policy {
    // {fact rule=improper-privilege-management@v1.0 defects=0}
    def compliant(pc: PermissionCollection): Unit = {
            // Compliant: Granted potentially safe permission.
            pc.add(new RuntimePermission("setFactory"))
    }
    // {/fact}
}