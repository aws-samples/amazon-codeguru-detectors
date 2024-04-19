
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=insecure-hashing@v1.0 defects=0}
function compliant($value) {
    // Compliant: Secure hashing algorithms
    $pass = hash('sha256', $value);
    $user->setPassword($pass);
}
//{/fact}
?>