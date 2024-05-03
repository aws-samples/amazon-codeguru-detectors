=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=improper-input-validation@v1.0 defects=0}
class InputValidation
  # Compliant: Properly bounded regex passed to validates.
  validates_format_of :good_valid, :with => /\A[a-zA-Z]\z/
end
# {/fact}
