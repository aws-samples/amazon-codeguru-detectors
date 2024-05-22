/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cross-site-request-forgery@v1.0 defects=0}
// Compliant: By default CSRF protection is enabled
@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http {
            csrf { }
            // Other security configurations...
        }
    }
}
// {/fact}
