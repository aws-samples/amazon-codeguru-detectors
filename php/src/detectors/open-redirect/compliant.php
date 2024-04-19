
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=open-redirect@v1.0 defects=0}
// Compliant: Secure way to redirect users to the current script itself without opening up the possibility of an open redirect
header('Location: '.$_SERVER['PHP_SELF']);
//{/fact}