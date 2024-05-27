/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import com.opensymphony.xwork2.ognl.OgnlUtil
import ognl.OgnlException
import java.util

class ExpressionLanguageInjectionCompliant {

    // {fact rule=expression-language-injection@v1.0 defects=0}
    @throws[OgnlException]
    @throws[ReflectionException]
    def compliant(ognlUtil: OgnlUtil, propsInput: util.HashMap[String,String]): Unit = {
        val input = "thisissafe"
        // Compliant: No untructed data injected into OGNL expression.
        ognlUtil.setValue(input, null, null, "12345")
    }
    // {/fact}

}