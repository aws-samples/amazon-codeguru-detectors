
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


//{fact rule=improper-authentication@v1.0 defects=0}
// Compliant: Credentials correctly passed as argument
ldap_bind($ldapconn, $username, $password); //compliant
//{/fact}


