<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/
	
    //{fact rule=sql-injection@v1.0 defects=1}
    // Noncompliant: tainted column name
    $tainted = $_GET['userinput'];
    $user = DB::table('users')->where($tainted, 'John')->first();
    // {/fact}
?>
	