<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=sendfile-injection@v1.0 defects=1}
$user_input = $_GET["tainted"];
// Noncompliant: $user_input is not sanitized.
include_once($user_input);
// {/fact}
?>