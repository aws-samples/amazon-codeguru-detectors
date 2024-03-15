/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=os-command-injection@v1.0 defects=1}
#include <iostream>

int osCommandInjectionNoncompliant() {
  std::string filename;
  std::cout << "Enter a filename: ";
  std::cin >> filename;
  std::string command = "ls " + filename;
  // Noncompliant: Untrusted user input passed into `system` method.
  system(filename.c_str());
  return 0;
}
// {/fact}