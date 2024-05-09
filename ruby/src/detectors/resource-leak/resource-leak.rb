=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=resource-leak@v1.0 defects=1}
def file_reading_noncompliant(filename)
  # Noncompliant: File hasn't been closed
  file = File.open(filename, 'r')
  contents = file.read
  puts contents
end
# {/fact}

# {fact rule=resource-leak@v1.0 defects=0}
def file_reading_compliant(filename)
  # Compliant: File has been closed after read
  File.open(filename, 'r') do |file|
    file.each_line do |line|
      puts line
    end
  end
end
# {/fact}
