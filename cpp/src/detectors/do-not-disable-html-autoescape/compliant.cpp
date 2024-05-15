/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=do-not-disable-html-autoescape@v1.0 defects=0}
#include <iostream>

void HTMLAuoescape() {
	   char* query = getenv("QUERY_STRING");
	   puts("<p>Query results for ");
	   // Compliant: Escape HTML characters before adding to a page
	   char* query_escaped = escape_html(query);
	   puts(query_escaped);
	   free(query_escaped);
	 
	   puts("\n<p>\n");
	   puts(do_search(query));
	 }
// {/fact}