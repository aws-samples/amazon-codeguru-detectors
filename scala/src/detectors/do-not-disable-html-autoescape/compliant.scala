/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters

class DoNotDisableHtmlAutoescapeCompliant extends WebPage {

    // {fact rule=do-not-disable-html-autoescape@v1.0 defects=0}
    def compliant(pageParameters: PageParameters): Unit = {
        // Compliant: Autoescape is enabled for this label.
        add(new Label("test").setEscapeModelStrings(true))
    }
    // {/fact}

}