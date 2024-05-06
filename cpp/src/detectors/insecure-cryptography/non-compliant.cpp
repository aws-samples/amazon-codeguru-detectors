/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-cryptography@v1.0 defects=1}
#include <iostream>

 void noncompliant1(EVP_PKEY_CTX *ctx)
	 {
	 
	     // Noncompiat: only 1024 bits for an RSA key
	     EVP_PKEY_CTX_set_rsa_keygen_bits(ctx, 1024);  
	 }
	    
// {/fact}