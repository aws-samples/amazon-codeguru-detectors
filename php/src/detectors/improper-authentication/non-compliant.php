
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=improper-authentication@v1.0 defects=1}
// Noncompliant: NULL values passed as password
ldap_bind($ldapconn, NULL, NULL); //nonCompliant
//{/fact}