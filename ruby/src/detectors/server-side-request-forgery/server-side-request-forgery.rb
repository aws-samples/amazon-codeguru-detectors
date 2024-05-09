=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=server-side-request-forgery@v1.0 defects=1}
require 'net/http'

def server_side_request_forgery_noncompliant
  url = params[:url]
  # Noncompliant: url is passing through `HTTP.get()`.
  Net::HTTP.get(url, "/index.html")
end
# {/fact}

# {fact rule=server-side-request-forgery@v1.0 defects=0}
def server_side_request_forgery_compliant
  url = params[:url]
  # Compliant: url is not passing through `HTTP.get()`.
  Net::HTTP.get("example.com", "/index.html")
end
# {/fact}
