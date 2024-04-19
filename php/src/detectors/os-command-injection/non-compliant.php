
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=os-command-injection@v1.0 defects=1}
$username = $_COOKIE['username'];
// Noncompliant: Incorporating variable into command strings
exec("wto -n \"$username\" -g", $ret);
//{/fact}

