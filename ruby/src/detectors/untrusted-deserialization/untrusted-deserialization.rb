=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=untrusted-deserialization@v1.0 defects=1}
def handler_noncompliant(event:, context:)
  foobar = event['smth']
  # Noncompliant: tainted data passed inside `CSV.load()`.
  obj3 = CSV.load("o:" + event['data'])
end
# {/fact}

# {fact rule=untrusted-deserialization@v1.0 defects=0}
def handler_compliant(event:, context:)
  # Compliant: no tainted data passed inside `CSV.load()`.
  obj3 = CSV.load(get_safe_data())
end
# {/fact}