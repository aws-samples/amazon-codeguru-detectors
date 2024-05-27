/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import org.springframework.ldap.core.LdapTemplate

// {fact rule=ldap-injection@v1.0 defects=1}
class LdapInjectionNoncompliant {
    @throws[NamingException]
    def nonCompliant(template: LdapTemplate, jndiInjectMe: String, searchControls: SearchControls, dirContextProcessor: DirContextProcessor): Unit = {
        // Noncompliant: Untrusted data used in LDAP queries.
        template.search(jndiInjectMe, "dn=1", mapper)
    }
}
// {/fact}