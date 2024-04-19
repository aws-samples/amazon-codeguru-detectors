
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=secure-signal-handling@v1.0 defects=0}
function compliant1($param)  {
    $targetPid = (int)$_GET["pid"];
    // Compliant: kills the process with validation
    if (isValidPid($targetPid)) {
        posix_kill($targetPid, 9);
    }
 }
//{/fact}

