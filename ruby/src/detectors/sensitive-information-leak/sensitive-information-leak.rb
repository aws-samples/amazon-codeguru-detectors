=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=sensitive-information-leak@v1.0 defects=1}
def sensitive_information_leak_noncompliant
    # Noncompliant: User-controlled data is passed in find.
    @user = User.find(params[:id])

    respond_to do |format|
      format.html 
      format.json { render :json => @user }
    end
end
# {/fact}

# {fact rule=sensitive-information-leak@v1.0 defects=0}
def sensitive_information_leak_compliant
    # Compliant: Argument in find is not user-controlled.
    @user = User.find(session[:id])

    respond_to do |format|
      format.html 
      format.json { render :json => @user }
    end
end
# {/fact}
