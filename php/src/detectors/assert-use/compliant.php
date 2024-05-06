<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=assert-use@v1.0 defects=0}
// Compliant : assert input is not tainted
    $tainted = $_GET['userinput'];
    assert('2 > 1');
// {/fact}
?>