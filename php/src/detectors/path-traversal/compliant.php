/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=path-traversal@v1.0 defect=0}
$user_input_compliant_4 = 'image.png';
$path = BASE_PATH . "/" . $user_input_compliant_4;
if(realpath($path) !== BASE_PATH . $user_input_compliant_4) {
    throw new InvalidPathException("Invalid path");
}
$json = file_get_contents($path);
//{/fact}
