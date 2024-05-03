=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=sensitive-http-action@v1.0 defects=1}
class AccountsController < ApplicationController
    def sensitive_http_get_noncompliant
        # Noncompliant: GET request with a catch all 'else' block which might catch HEAD requests unknowingly
        if request.get?
            # Process request
        else
            # Process request
        end
    end
end
# {/fact}
