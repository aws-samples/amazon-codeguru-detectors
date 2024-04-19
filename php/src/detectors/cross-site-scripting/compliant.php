<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=cross-site-scripting@v1.0 defects=0}
function compliant() {
    $name = $_REQUEST['name'];
    // Compliant: 'htmlentities' provides a compliant way to display user input safely.
    print("Hello : " . htmlentities($name));
}
//{/fact}
