/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-bean-validation@v1.0 defects=0}
// Compliant: Safe Bean properties are passed to `buildConstraintViolationWithTemplate`
fun compliant(request: HttpServletRequest, response: HttpServletResponse, constraintContext: ConstraintValidatorContext) {
    val context: HibernateConstraintValidatorContext = constraintContext.unwrap(HibernateConstraintValidatorContext::class.java)
    context.addMessageParameter("prop", request.getParameter("prop"))
    context.buildConstraintViolationWithTemplate("{prop} is invalid").addConstraintViolation()
    return false
}
// {/fact}