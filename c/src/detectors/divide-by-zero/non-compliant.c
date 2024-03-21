/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=divide-by-zero@v1.0 defects=1}
struct OptionalInt divideByZeroNonCompliant(int a, int b) {
   struct OptionalInt result;
  // While the following check correctly prevents signed integer overflows,
  // it fails to prevent divide-by-zero errors. If `b` is equal to `0`, the
  // application emits undefined behavior.
  if ((a == INT_MIN) && (b == -1)) {
    result.has_value = 0;
    return result;
  }
  result.has_value = 1;
  // Noncompliant: Performing division without checking if the denominator is zero will lead to division by zero errors
  result.value = a / b; 
  return result; // causes undefined behavior if `b` is zero
}
// {/fact}