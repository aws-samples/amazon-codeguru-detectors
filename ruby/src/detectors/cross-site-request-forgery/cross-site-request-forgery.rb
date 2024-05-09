=begin
 Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=cross-site-request-forgery@v1.0 defects=1}
def cross_site_request_forgery_noncompliant
  user = params[:user_id]
  users_service_domain = params[:users_service_domain]
  # Noncompliant: Complete URL is user-controlled.
  response = Excon.post("#{users_service_domain}/logins", body: {user_id: user}).body
  token = JSON.parse(response)["token"]
end
# {/fact}

# {fact rule=cross-site-request-forgery@v1.0 defects=0}
def cross_site_request_forgery_compliant
  user = params[:user_id]
  users_service_path = params[:users_service_path]
  # Compliant: Only suffix of the URL is controlled by user.
  response = Excon.post("users-service/#{users_service_path}", body: {user_id: user}).body
  token = JSON.parse(response)["token"]
end
# {/fact}
