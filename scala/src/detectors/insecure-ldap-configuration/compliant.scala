/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.naming.directory.SearchControls

class InsecureLdapConfigurationCompliant {
  private val scope = 0
  private val countLimit = 0
  private val timeLimit = 0
  private val attributes = null
  private val deref = false

  // {fact rule=insecure-ldap-configuration@v1.0 defects=0}
  def compliant(): Unit = {
    // Compliant: `returnObjFlag` is set to false
    new SearchControls(scope, countLimit, timeLimit, attributes, false,
      deref)
  }
  // {/fact}

}