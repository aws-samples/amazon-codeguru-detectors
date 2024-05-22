/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cross-site-request-forgery@v1.0 defects=1}
// Noncompliant: CSRF protection disabled
@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    protected fun configure(http: HttpSecurity) {
        http {
            csrf().disable()
            // Other security configurations...
        }
    }
    }
// {/fact}
