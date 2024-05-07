=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=tainted-format@v1.0 defects=1}
class TaintedFormat < ActionController::Base
  def unsanitized_input
    # Noncompliant: untrusted user input is being used directly in format sting.
    printf(params[:format], arg)
  end
end
# {/fact}