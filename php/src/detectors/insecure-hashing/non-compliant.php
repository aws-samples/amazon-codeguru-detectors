
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=insecure-hashing@v1.0 defect=1}
function nonCompliant($value) {
    //NonCompliant: Weak hash algorithm used
    $pass = hash('md5', $value);
    $user->setPassword($pass);
}
//{/fact}
