/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

use Defuse\Crypto\KeyOrPassword;

//{fact rule=hardcoded-credentials@v1.0 defect=1}
function nonCompliant() {
    $password = "3xAmpl3";
    return KeyOrPassword::createFromPassword($password);
}
//{/fact}
