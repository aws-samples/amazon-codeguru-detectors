=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=sensitive-http-action@v1.0 defects=0}
class AccountsController < ApplicationController
    def sensitive_http_get_compliant
        # Compliant: GET request with 'elsif' which means exclusive blocks for other http methods
        if request.get?
            # Process request
        elsif request.post?
            # Process request
        end
    end
end
# {/fact}
