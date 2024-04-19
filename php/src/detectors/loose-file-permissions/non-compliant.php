
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=loose-file-permissions@v1.0 defects=1}
$fs = new Filesystem();
// Noncompliant: `0777` as it gives full read, write, and execute permissions to all users, which can be a security risk.
$fs->chmod("foo", 0777);
//{/fact}
