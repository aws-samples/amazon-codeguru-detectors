<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-cryptography@v1.0 defects=0}
// Compliant : SHA-256 is secure hashing algorithm
function compliant($value) {
    $pass = hash('sha256', $value);
    $user->setPassword($pass);
}
// {/fact}
?>