<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

    //{fact rule=sql-injection@v1.0 defects=0}
    // Compliant: column name is fixed
    $tainted = $_GET['userinput'];
    $user = DB::table('users')->where('name', $tainted)->first();
    // {/fact}

?>