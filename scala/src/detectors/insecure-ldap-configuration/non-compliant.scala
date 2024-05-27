/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.naming.directory.SearchControls

class InsecureLdapConfigurationNoncompliant {
  private val scope = 0
  private val countLimit = 0
  private val timeLimit = 0
  private val attributes = null
  private val deref = false

  // {fact rule=insecure-ldap-configuration@v1.0 defects=1}
  def nonCompliant(): Unit = {
    // Noncompliant: `returnObjFlag` is set to true
    new SearchControls(scope, countLimit, timeLimit, attributes, true, //!! It will flag line 14 ... the beginning of the call
      deref)
  }
  // {/fact}
}