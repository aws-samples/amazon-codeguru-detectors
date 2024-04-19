
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=open-redirect@v1.0 defects=1}
// Noncompliant: `$_SERVER["REQUEST_URI"]` directly in the 'Location' header can potentially introduce an open redirect vulnerability
header('Location: '.$_SERVER["REQUEST_URI"]);
//{/fact}
