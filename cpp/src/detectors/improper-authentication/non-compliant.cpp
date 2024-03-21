/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-authentication@v1.0 defects=1}
#include <iostream>

void improperAuthenticationNoncompliant() {
    std::string secret = "your_secret_key";

    std::string correctToken = create()
                                .set_issuer("your_issuer")
                                .set_type("JWT")
                                .set_payload_claim("user_id", claim("123"))
                                .sign(algorithm::hs256{ secret });

    std::string inCorrectToken = "invalid_token";

    try {
        // Noncompliant: Insecure Token has been used.
        auto decoded_token = decode(inCorrectToken, algorithms({ algorithm::hs256{ secret } }));
    } catch (const std::exception& e) {
        std::cerr << "Error decoding or verifying token: " << e.what() << std::endl;
    }
}
// {/fact}