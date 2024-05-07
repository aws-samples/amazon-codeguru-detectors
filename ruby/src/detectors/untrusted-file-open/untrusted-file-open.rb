=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=untrusted-file-open@v1.0 defects=0}
filename = "testfile"
# Compliant: File being opened is static.
open(filename) do |f|
  print f.gets
end
# {/fact}

# {fact rule=untrusted-file-open@v1.0 defects=1}

# Noncompliant: User-input directly controls which file is opened.
cmd = open("|%s" % params[:file)
print cmd.gets
cmd.close
# {/fact}
