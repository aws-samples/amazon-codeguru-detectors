<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=assert-use@v1.0 defects=1}
// NonCompliant: the userinput is not sanitized
    $tainted = $_GET['userinput'];
    assert($tainted);
// {/fact}
?>