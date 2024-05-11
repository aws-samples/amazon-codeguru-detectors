<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=detect-activated-debug-feature@v1.0 defects=0}
// Compliant: Debug mode is disabled
    config(['app.debug' => 'false']);
// {/fact}
?>