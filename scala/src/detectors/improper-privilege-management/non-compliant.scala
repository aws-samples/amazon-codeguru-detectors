/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.lang.reflect.ReflectPermission
import java.security.CodeSource
import java.security.PermissionCollection
import java.security.Policy

class ImproperPrivilegeManagementNoncompliant extends Policy {
    // {fact rule=improper-privilege-management@v1.0 defects=1}
    def nonCompliant(cs: CodeSource): Unit = {
            val pc: PermissionCollection = super.getPermissions(cs)
            // Noncompliant: This permission is insecure.
            pc.add(new ReflectPermission("suppressAccessChecks"))
    }
    // {/fact}
}