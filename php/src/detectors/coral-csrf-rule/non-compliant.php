<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=coral-csrf-rule@v1.0 defects=1}
// Noncompliant: CSRF protection is disabled
$resolver->setDefaults(array(
    'csrf_protection' => false
  ));
// {/fact}
?>