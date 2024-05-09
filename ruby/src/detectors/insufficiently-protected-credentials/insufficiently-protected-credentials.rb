=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=insufficiently-protected-credentials@v1.0 defects=1}
require 'jwt'

def insufficiently_protected_credentials_noncompliant(hmac_secret)
  # Noncompliant: JWT password is hardcoded in payload.
  payload = { data: 'data', password: 12345 }
  token = JWT.encode payload, hmac_secret, 'HS256'
  puts token
end
# {/fact}

# {fact rule=insufficiently-protected-credentials@v1.0 defects=0}
def insufficiently_protected_credentials_compliant(hmac_secret)
  # Compliant: JWT password is not hardcoded.
  payload = { data: 'data', nbf: nbf }
  token = JWT.encode payload, hmac_secret, 'HS256'
  puts token
end
# {/fact}
