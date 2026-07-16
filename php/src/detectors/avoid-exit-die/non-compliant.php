<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=avoid-exit-die@v1.0 defects=1}
// Noncompliant : exit() is used to terminate the script
function nonCompliant($param)  {
    if ($param === 42) {
        exit(23);
    }
}
// {/fact}
?>