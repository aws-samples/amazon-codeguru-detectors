<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=unsafe-reflection@v1.0 defects=1}
// Noncompliant: Uses reflection to create a controller object
$parts = explode("/", $_SERVER['PATH_INFO']);
$controllerName = $parts[0];
$controller = new $controllerName($parts[1]);
 // {/fact}
?>