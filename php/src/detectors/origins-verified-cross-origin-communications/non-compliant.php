<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=origins-verified-cross-origin-communications@v1.0 defects=1}
// Noncompliant: Access-Control-Allow-Origin` header to `*` can allow any origin to access sensitive resources without proper verification.
header('Access-Control-Allow-Origin: *');
// {/fact}

?>