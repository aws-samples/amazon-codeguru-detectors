<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=avoid-exit-die@v1.0 defects=0}
// Compliant: Exception thrown in a compliant way.
function compliant($param)  {
    if ($param == 42) {
      throw new Exception('Value 42 is not expected.');
    }
}
// {/fact}
?>