<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=dangerous-function-usage@v1.0 defects=1}
// Noncompliant: `mcrypt_ecb` function to perform encryption using the ECB 
    mcrypt_ecb(MCRYPT_BLOWFISH, $key, base64_decode($input), MCRYPT_ENCRYPT);
// {/fact}

?>