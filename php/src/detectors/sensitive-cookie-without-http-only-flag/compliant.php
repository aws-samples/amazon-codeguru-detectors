/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=sensitive-cookie-without-http-only-flag@v1.0 defect=0}
session_set_cookie_params($lifetime, $path, $domain, true, true);
//{/fact}
?>
