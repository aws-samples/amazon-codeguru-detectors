
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=path-traversal@v1.0 defect=1}
//NonCompliant: Direct utilization of path without adequate validation
$path = '.../.../password';
$localeFunctions = file_get_contents($path);
//{/fact}