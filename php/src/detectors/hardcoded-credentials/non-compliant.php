
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


use Defuse\Crypto\KeyOrPassword;

//{fact rule=hardcoded-credentials@v1.0 defects=1}
function nonCompliant() {
    // NonCompliant: Stored passwords directly in the code statement
    $password = "3xAmpl3";
    return KeyOrPassword::createFromPassword($password);
}
//{/fact}
