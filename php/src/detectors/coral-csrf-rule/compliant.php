<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=coral-csrf-rule@v1.0 defects=0}
// Compliant: CSRF protection enabled
$resolver->setDefaults([
    'csrf_protection' => true
  ]);
// {/fact}
?>