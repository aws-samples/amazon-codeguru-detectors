=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=os-command-injection@v1.0 defects=0}
require "shellwords"

class UsersController < ActionController::Base
  def oscommand_injection_noncompliant
    cmd = params[:cmd]
    safe_cmd = Shellwords.escape(cmd)
    # Compliant: User data has been escaped
    system(safe_cmd)
  end
end
# {/fact}
