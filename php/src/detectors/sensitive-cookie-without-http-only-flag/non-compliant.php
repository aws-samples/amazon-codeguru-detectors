
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=sensitive-cookie-without-http-only-flag@v1.0 defects=1}
// Noncompliant: http-only flag set to false
session_set_cookie_params($lifetime, $path, $domain, true, false);
//{/fact}
