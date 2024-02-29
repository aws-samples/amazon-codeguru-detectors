/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=loose-file-permissions@v1.0 defect=1}
$fs = new Filesystem();
$fs->chmod("foo", 0777);
//{/fact}
