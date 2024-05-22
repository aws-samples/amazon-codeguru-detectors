/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=log-injection@v1.0 defects=1}
// Noncompliant: Unsanitized user data is being written to the logs
fun noncompliant(request: ServletRequest) {
    val xValue = request.getParameter("x")
    logger.info("Value is: {}", xValue)
}
// {/fact}
