=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=code-injection@v1.0 defects=1}
def code_injection_noncompliant()
  code = params[:code]
  # Noncompliant: User input is not sanitized.
  @result = User.send(code)
end
# {/fact}

# {fact rule=code-injection@v1.0 defects=0}
def code_injection_compliant()
  method = params[:method] == 1 ? :method_a : :method_b
  # Compliant: User input is not passed in User.send().
  @result = User.send(method, *args)
end
# {/fact}
