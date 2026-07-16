<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=ldap-bind-without-password@v1.0 defect=0}
// Compliant: username and passwrod provided
ldap_bind($ldapconn, "username", "password");
//{fact}
?>