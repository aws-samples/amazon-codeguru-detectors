/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-pointer-scaling@v1.0 defects=1}

inline char incorrectPointerScalingNonComplaint(int i) {
  int intArray[5] = { 1, 2, 3, 4, 5 };
  char *charPointer = (char *)intArray;
  // Noncompliant: the pointer arithmetic uses type char*, so the offset
  // is not scaled by sizeof(int).
  return *(charPointer + i);
}
// {/fact}