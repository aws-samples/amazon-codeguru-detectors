=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=os-command-injection@v1.0 defects=1}
class UsersController < ActionController::Base
  def oscommand_injection_compliant
    cmd = params[:cmd]
    # Noncompliant: User data used directly as a command without escaping
    system(cmd)
   end
end
# {/fact}