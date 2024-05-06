/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-cryptography@v1.0 defects=0}
#include <iostream>

 void compliant1(EVP_PKEY_CTX *ctx)
	 {
	     
	     // compliaint: 2048 bits for an RSA key
	     EVP_PKEY_CTX_set_rsa_keygen_bits(ctx, 2048);
	    
	 }
// {/fact}