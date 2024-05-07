=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=improper-certificate-validation@v1.0 defects=1}
require "httparty"

def certificate_validation_noncompliant

  # Noncompliant: SSL certificate validation is disabled.
  HTTParty.get("http://example.com/", verify: false)

end
# {/fact}

# {fact rule=improper-certificate-validation@v1.0 defects=0}
require "httparty"

def certificate_validation_compliant

  # Compliant: SSL certificate validation is enabled.
  HTTParty.get("http://example.com/", verify: true)

end
# {/fact}
