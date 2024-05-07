=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

class FooController < ApplicationController

  # {fact rule=stack-trace-exposure@v1.0 defects=1}
  def exposure_of_stack_trace_noncompliant
        # Process
      rescue => e
        # Noncompliant: Rendering the stack trace information
        render body: e.backtrace, content_type: "text/plain"
   end
   # {/fact}

  # {fact rule=stack-trace-exposure@v1.0 defects=0}
  def exposure_of_stack_trace_compliant
    # Process
    rescue => e
      # Compliant: Rending a simple error message.
      render body: "An error occurred", content_type: "text/plain"
  end
  # {/fact}
end
