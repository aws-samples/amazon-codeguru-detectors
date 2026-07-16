<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=sendfile-injection@v1.0 defects=0}
// Compliant: Non tainted input is passed to the function
include_once('constant.php');
// {/fact}
?>