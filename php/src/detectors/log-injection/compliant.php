<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

    // {fact rule=log-injection@v1.0 defects=0}
    // Compliant: `log_errors` is set to `'1'`, PHP will log errors to the error log file.
    ini_set('log_errors', '1');
    // {/fact}
    
?>