/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=log-injection@v1.0 defects=0}
// Compliant: Sanitized user data is being written to the logs
fun compliant(input: String) {
    logger.info("Value is: {}", input)
}
// {/fact}
