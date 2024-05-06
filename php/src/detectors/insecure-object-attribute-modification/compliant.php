<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-object-attribute-modification@v1.0 defects=0}
// Compliant: guarded model initialised with value
protected $guarded = ['name', 'email'];
// {/fact}
?>