<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=cross-site-scripting@v1.0 defects=1}
function nonCompliant() {
    $name = $_REQUEST['name'];
    // Noncompliant: '$name' statement is non-compliant as it can leave the application vulnerable to cross-site scripting attacks.
    echo "Hello :".$name;
}
//{/fact}