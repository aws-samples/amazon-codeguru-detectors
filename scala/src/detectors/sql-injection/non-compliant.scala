/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.sql.{Connection, ResultSet, DriverManager}
import org.slf4j.LoggerFactory

object SqlInjectionNoncompliant {
    // {fact rule=sql-injection@v1.0 defects=1}
    def nonCompliant(name: String) = {
        val sql = "SELECT * FROM table WHERE name = " + name + ";"
        val conn = DriverManager.getConnection("jdbc:mysql://localhost:8080", "guest", "password")
        val stmt = conn.createStatement()
        // Noncompliant: The code directly concatenates user input into the SQL query, making it vulnerable to SQL injection attacks.
        val rs = stmt.execute(sql)
        rs
    }
    // {/fact}
}