/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=cross-site-scripting@v1.0 defect=1}
function nonCompliant() {
    $name = $_REQUEST['name'];
    echo "Hello :".$name;
}
//{/fact}