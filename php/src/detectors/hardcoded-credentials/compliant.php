
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

use Defuse\Crypto\KeyOrPassword;
//{fact rule=hardcoded-credentials@v1.0 defects=0}
function compliant() {
    // Compliant: Access sensitive information like passwords directly from environment variables
    $password = $_ENV["SECRET"];
    return KeyOrPassword::createFromPassword($password);
}
//{/fact}