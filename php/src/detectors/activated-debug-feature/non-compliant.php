<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=detect-activated-debug-feature@v1.0 defects=1}
// Noncompliant:  Debug mode is eanbled
    config(['app.debug' => 'true']); 
// {/fact}
?>