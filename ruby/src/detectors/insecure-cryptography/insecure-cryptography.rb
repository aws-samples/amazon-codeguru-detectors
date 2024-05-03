=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=insecure-cryptography@v1.0 defects=1}
require 'openssl'

def cryptography_noncompliant()
  # Noncompliant: weak block mode
  OpenSSL::Cipher::AES.new(128, :ecb)
end
# {/fact}

# {fact rule=insecure-cryptography@v1.0 defects=0}
def cryptography_compliant()
  # Compliant: strong encryption algorithm
  OpenSSL::Cipher::AES.new(128, :gcm)
end
# {/fact}