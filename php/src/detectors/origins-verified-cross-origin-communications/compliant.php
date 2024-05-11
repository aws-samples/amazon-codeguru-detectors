<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=origins-verified-cross-origin-communications@v1.0 defects=0}
// Compliant: Custom header with a wildcard value does not pose a risk to cross-origin communication
header("Other-Property: *");
// {/fact}
    
?>