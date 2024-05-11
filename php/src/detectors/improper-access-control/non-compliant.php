<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


//{fact rule=improper-access-control@v1.0 defects=1}
// Noncompliant: tainted session variable is used in a session 
    $inputA = $_POST['input'];
	$_SESSION[$inputA] = true;
//{/fact}

?>