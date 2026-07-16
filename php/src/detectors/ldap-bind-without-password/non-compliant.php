<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=ldap-bind-without-password@v1.0 defect=1}
// Noncompliant: username and password is missing  
ldap_bind($ldapconn, NULL, NULL);
// {fact}
?>