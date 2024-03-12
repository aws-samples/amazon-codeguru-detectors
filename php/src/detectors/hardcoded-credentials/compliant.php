/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php
use Defuse\Crypto\KeyOrPassword;
//{fact rule=hardcoded-credentials@v1.0 defect=0}
function compliant() {
    $password = $_ENV["SECRET"];
    return KeyOrPassword::createFromPassword($password);
}
//{/fact}