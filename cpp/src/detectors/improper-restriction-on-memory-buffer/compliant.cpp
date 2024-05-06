/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-restriction-on-memory-buffer@v1.0 defects=0}
#include <iostream>

 void compliantTest1() {
	     char buffer[20];
	     const char* data = "ThisIsALongString";
	     // Compliant: `strncpy` used to prevent buffer overflow
	     strncpy(buffer, data, sizeof(buffer) - 1);
	     buffer[sizeof(buffer) - 1] = '\0';  // Null-terminate the string
	 }
	    
// {/fact}