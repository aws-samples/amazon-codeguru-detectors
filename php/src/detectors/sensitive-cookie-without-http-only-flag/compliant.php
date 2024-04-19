
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=sensitive-cookie-without-http-only-flag@v1.0 defects=0}
// Compliant: http-only flag set to true
session_set_cookie_params($lifetime, $path, $domain, true, true);
//{/fact}
?>
