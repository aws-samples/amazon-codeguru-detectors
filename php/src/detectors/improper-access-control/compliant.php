<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=improper-access-control@v1.0 defects=0}
// Compliant: The session prefix is used to prevent 
    $inputA = $_POST['input'];
    $_SESSION['prefix' . $_POST['input']] = true;
//{/fact}

?>