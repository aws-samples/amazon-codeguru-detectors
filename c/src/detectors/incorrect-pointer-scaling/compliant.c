/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-pointer-scaling@v1.0 defects=0}

inline int incorrectPointerScalingComplaint(int i) {
  int intArray[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  int *intPointer = intArray;
  // Compliant: the offset is automatically scaled by sizeof(int).
  return *(intPointer + i);
}
// {/fact}