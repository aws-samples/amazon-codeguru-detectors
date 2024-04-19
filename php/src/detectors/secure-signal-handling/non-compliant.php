
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=secure-signal-handling@v1.0 defects=1}
function nonCompliant1($param)  {
    $targetPid = (int)$_GET["pid"];
    // Noncompliant: kills the process without validation
    posix_kill($targetPid, 9);
}
//{/fact}