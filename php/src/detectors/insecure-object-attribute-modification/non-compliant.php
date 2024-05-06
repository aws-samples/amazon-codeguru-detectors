<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-object-attribute-modification@v1.0 defects=1}
// Noncompliant: use of guarded array property.
protected $guarded = [];
// {/fact}

?>