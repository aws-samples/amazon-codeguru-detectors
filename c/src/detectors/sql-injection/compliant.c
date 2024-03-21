/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=sql-injection@v1.0 defects=0}
#include <stdio.h>
#include <mysql.h>
#include <stdlib.h>
#include <sqlite3.h>

void sqlInjectionCompliant(int argc, char** argv) {
    MYSQL *connection = mysql_init(NULL);
    if (mysql_real_connect(connection, "localhost", "root", "root_passwd", NULL, 0, NULL, 0) == NULL) {
        fprintf(stderr, "%s\n", mysql_error(connection));
        mysql_close(connection);
        exit(1);
    }
    char query[200];
    char* name = argv[1];
    char escaped_name[100];
    mysql_real_escape_string(connection, escaped_name, name, strlen(name)); 
    // Compliant: This is safe as `mysql_real_escape_string` escapes potentially malicious characters
    sprintf(query, "SELECT * FROM users WHERE name = '%s'", escaped_name); 
    mysql_query(connection, query);
}
// {/fact}