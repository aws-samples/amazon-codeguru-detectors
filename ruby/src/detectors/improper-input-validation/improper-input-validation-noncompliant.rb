=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=improper-input-validation@v1.0 defects=1}
class InputValidation
  # Noncompliant: Improperly bounded regex passed to validates.
  validates :username, :length => 6..20, :format => /([a-z][0-9])+/i

  accepts_nested_attributes_for :author, :pages
end
# {/fact}