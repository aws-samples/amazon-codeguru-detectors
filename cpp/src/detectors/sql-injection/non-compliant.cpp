/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=sql-injection@v1.0 defects=1}
#include <iostream>
#include <sqlite3.h>

int sqlInjectionNoncompliant(const std::string& username, const std::string& password) {
    sqlite3* db;
    sqlite3_open("users.db", &db);

    std::string query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "';";

    sqlite3_stmt* stmt;
    // Noncompliant: This code takes a username and password from the user, constructs an SQL query, and tries to authenticate the user against an SQLite database.
    if (sqlite3_prepare_v2(db, query.c_str(), -1, &stmt, nullptr) == SQLITE_OK) {
        if (sqlite3_step(stmt) == SQLITE_ROW) {
            std::cout << "Authentication successful.\n";
            return 1;
        }
    }

    std::cout << "Authentication failed.\n";
    return 0;
}
// {/fact}