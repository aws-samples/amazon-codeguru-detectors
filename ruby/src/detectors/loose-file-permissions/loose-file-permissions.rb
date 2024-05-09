=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=loose-file-permissions@v1.0 defects=1}
require "fileutils"

def open_file_permission_noncompliant(filename)

  # Noncompliant: sets file world writable.
  FileUtils.chmod 0222, filename
end
# {/fact}

# {fact rule=loose-file-permissions@v1.0 defects=0}
def open_file_permission_compliant(filename)

  # Compliant: restricts group/world access.
  FileUtils.chmod 0700, filename
end
# {/fact}