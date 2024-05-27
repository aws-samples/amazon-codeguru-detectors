/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import org.springframework.ldap.core.LdapTemplate

// {fact rule=ldap-injection@v1.0 defects=0}
class LdapInjectionCompliant {
    @throws[NamingException]
    def compliant(template: LdapTemplate, jndiInjectMe: String, searchControls: SearchControls, dirContextProcessor: DirContextProcessor): Unit = {
        // Compliant: Untrusted data is not used in LDAP queries.
        val safeQuery = "uid=test"
        template.list(safeQuery)
    }
}
// {/fact}