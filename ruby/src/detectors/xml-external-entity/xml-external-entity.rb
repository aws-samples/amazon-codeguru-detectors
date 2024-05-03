=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=xml-external-entity@v1.0 defects=1}
def xml_external_entity_noncompliant()
  # Noncompliant: Disabling encryption of sensitive data
  config.force_ssl = false
end
# {/fact}

# {fact rule=xml-external-entity@v1.0 defects=0}
def xml_external_entity_compliant()
  # Compliant: Sensitive data is encrypted
  config.force_ssl = true
end
# {/fact}
