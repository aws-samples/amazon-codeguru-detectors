/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=sql-injection@v1.0 defects=0}
// Compliant: Hardcoded value is being passed to SQL query
fun compliant(connection: Connection): ResultSet {
    val userId = "hardcoded_value"
    val query = "SELECT * FROM users WHERE userId = '$userId'"
    val statement = connection.createStatement()
    return statement.executeQuery(query)
}
// {/fact}
