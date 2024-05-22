/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-bean-validation@v1.0 defects=1}
// Noncompliant: Unsafe Bean properties are passed directly to `buildConstraintViolationWithTemplate`
fun noncompliant(request: HttpServletRequest, response: HttpServletResponse, constraintContext: ConstraintValidatorContext) {
    val constraintViolation: String = request.getAttribute("constraintViolation").toString()
    constraintContext.buildConstraintViolationWithTemplate(constraintViolation)
    .addConstraintViolation()
    .disableDefaultConstraintViolation()
}
// {/fact}