
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=loose-file-permissions@v1.0 defects=0}
// Compliant: Used more restrictive file permissions 0750
chmod("foo", 0750);
//{/fact}
?>
