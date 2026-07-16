<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=unsafe-reflection@v1.0 defects=0} 
// Compliant: No reflection is used.   
$myController= "MyController";
$controller = new $myController();
// {/fact}

?>