<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=dangerous-function-usage@v1.0 defects=0}
// Compliant: `openssl_encrypt` function to perform encryption using the OpenSSL library.
    openssl_encrypt($plaintext, $cipher, $key, $options=0, $iv, $tag);
// {/fact}
?>