<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=allow-url-fopen-or-include@v1.0 defects=0}
// Compliant: `allow_url_fopen` set to `'Off'` 
    ini_set('allow_url_fopen','Off');
// {/fact}
?>