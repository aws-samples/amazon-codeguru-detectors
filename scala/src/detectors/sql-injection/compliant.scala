/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.sql.{Connection, ResultSet, DriverManager}
import org.slf4j.LoggerFactory

object SqlInjectionCompliant {
    // {fact rule=sql-injection@v1.0 defects=0}
    def compliant(name: String) = {
        val foobar = getFoobarFromEnv()
        val sql = "SELECT * FROM table WHERE name = " + foobar + ";"
        val conn = DriverManager.getConnection("jdbc:mysql://localhost:8080", "guest", "password")
        val stmt = conn.createStatement()
        // Compliant: The code does not use user input directly in SQL queries, mitigating the risk of SQL injection.
        val rs = stmt.execute(sql)
        rs
    }
    // {/fact}
}