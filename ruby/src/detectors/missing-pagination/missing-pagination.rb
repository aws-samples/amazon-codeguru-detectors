=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=missing-pagination@v1.0 defects=1}
def missing_pagination_noncompliant
  s3 = Aws::S3::Client.new
  # Noncompliant: Missing pagination
  response = s3.list_objects(bucket:'your-bucket-name')
  puts response.contents.map(&:key)
end
# {/fact}

# {fact rule=missing-pagination@v1.0 defects=0}
def missing_pagination_compliant
  s3 = Aws::S3::Client.new
  # Compliant: Pagination used correctly
  s3.list_objects(bucket:'your-bucket-name').each do |response|
    puts response.contents.map(&:key)
  end
end
# {/fact}
