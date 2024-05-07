=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

require 'logger'

class UsersController < ApplicationController
  include ERB::Util

  def init_logger
    if @logger == nil
      @logger = Logger.new STDOUT
    end
  end
  
# {fact rule=log-injection@v1.0 defects=1}
  def log_params_noncompliant
    init_logger

    unsanitized = params[:foo]
    # Noncompliant: Unsanitized user-input is used in logger
    @logger.error "input: " + unsanitized 
  end
# {/fact}
  

# {fact rule=log-injection@v1.0 defects=0}
  def log_params_compliant
    init_logger

    unsanitized = params[:foo]

    sanitized = unsanitized.gsub("\n", "")
    # Compliant: Sanitized user-input is used in logger
    @logger.warn "input: " + sanitized 
  end
# {/fact}

end