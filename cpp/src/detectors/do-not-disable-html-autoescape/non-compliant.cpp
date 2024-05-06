/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=do-not-disable-html-autoescape@v1.0 defects=1}
#include <iostream>

void noncompliant1() {
	   char* query = getenv("QUERY_STRING");
	   puts("<p>Query results for ");
	   // Noncompliant: Printing out an HTTP parameter with no escaping
	   puts(query);
	   puts("\n<p>\n");
	   puts(do_search(query));
	 }
// {/fact}