=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=cross-site-scripting@v1.0 defects=1}
def crosssite_scripting_noncompliant
  name = params[":name"]
  # Noncompliant: The parameter is not escaped.
  "<h2>#{name}</h2>".html_safe
end
# {/fact}

# {fact rule=cross-site-scripting@v1.0 defects=0}
def crosssite_scripting_compliant
  name = params[":name"]
  # Compliant: Parameter is escaped.
  "<h2>#{ERB::Util.html_escape(name)}</h2>".html_safe
end
# {/fact}
