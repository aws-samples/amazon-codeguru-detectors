/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-authentication@v1.0 defects=1}
// Noncompliant: Permiting anonymous users to execute LDAP statements
fun noncompliant(env: Environment): Void {
    env.put(Context.SECURITY_AUTHENTICATION, "none")
    val ctx: DirContext = InitialDirContext(env)
}
// {/fact}
