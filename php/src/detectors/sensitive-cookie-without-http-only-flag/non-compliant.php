
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=sensitive-cookie-without-http-only-flag@v1.0 defect=1}
//NonCompliant: http-only flag set to false
session_set_cookie_params($lifetime, $path, $domain, true, false);
//{/fact}
