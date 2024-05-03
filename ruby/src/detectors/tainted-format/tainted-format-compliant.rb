=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=tainted-format@v1.0 defects=0}
class TaintedFormat < ActionController::Base
  def sanitized_input
    # Compliant: User-input is not used to format output.
    printf(params[:format])
  end
end
# {/fact}
