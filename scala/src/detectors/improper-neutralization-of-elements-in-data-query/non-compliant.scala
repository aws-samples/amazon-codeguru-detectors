/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServlet
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpledb.AmazonSimpleDBClient
import com.amazonaws.services.simpledb.model.SelectRequest


class ImproperNeutralizationOfElementsInDataQueryNoncompliant extends HttpServlet {

    // {fact rule=improper-neutralization-of-elements-in-data-query@v1.0 defects=1}
    @throws[IOException]
    override def nonCompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        try {
            val customerID = request.getParameter("customerID")
            val awsCredentials = new BasicAWSCredentials("test", "test")
            val sdbc = new AmazonSimpleDBClient(awsCredentials)
            val query = "select * from invoices where customerID = " + customerID
            // Noncompliant: Using untrusted HTTP request parameters into SQL queries.
            val sdbResult = sdbc.select(new SelectRequest(query))
        } catch {
            case _: Throwable =>
        }
    }
    // {/fact}
}
