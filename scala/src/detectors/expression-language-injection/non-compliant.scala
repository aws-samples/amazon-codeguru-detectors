/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import com.opensymphony.xwork2.ognl.OgnlUtil
import ognl.OgnlException
import java.util

class ExpressionLanguageInjectionNoncompliant {

    // {fact rule=expression-language-injection@v1.0 defects=1}
    @throws[OgnlException]
    @throws[ReflectionException]
    def nonCompliant(ognlUtil: OgnlUtil, input: String, propsInput: util.HashMap[String,String]): Unit = {
        // Noncompliant: Untructed data injected into OGNL expression.
        ognlUtil.setValue(input, null, null, "12345")
    }
    // {/fact}

}