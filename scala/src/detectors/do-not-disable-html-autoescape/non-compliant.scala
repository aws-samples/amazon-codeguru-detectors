/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters

class DoNotDisableHtmlAutoescapeNoncompliant extends WebPage {

    // {fact rule=do-not-disable-html-autoescape@v1.0 defects=1}
    def nonCompliant(pageParameters: PageParameters): Unit = {
        // Noncompliant: Autoescape is disabled for this label.
        add(new Label("test").setEscapeModelStrings(false))
    }
    // {/fact}

}