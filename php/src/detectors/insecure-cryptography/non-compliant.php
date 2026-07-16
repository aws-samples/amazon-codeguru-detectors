<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-cryptography@v1.0 defects=1}
// Noncompliant: Weak hashing algorithm MD5 is used
function nonCompliant($value) { 
    $pass = hash('md5', $value);
    $user->setPassword($pass);
}
// {/fact}
?>