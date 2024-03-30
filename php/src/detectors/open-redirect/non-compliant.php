
<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=open-redirect@v1.0 defect=1}
//NonCompliant: `$_SERVER["REQUEST_URI"]` directly in the 'Location' header can potentially introduce an open redirect vulnerability
header('Location: '.$_SERVER["REQUEST_URI"]);
//{/fact}
