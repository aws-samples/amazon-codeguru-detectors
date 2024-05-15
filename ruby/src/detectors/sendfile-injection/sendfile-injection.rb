=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=sendfile-injection@v1.0 defects=1}
def download
    begin
      path = "/opt/wwwdata/assets/" + params[:asset_name].to_s
      # Noncompliant: 'path' is unsanitized.
      send_file path, disposition: "attachment"
    rescue
      redirect_to "/home"
    end
 end
 # {/fact}
 
 # {fact rule=sendfile-injection@v1.0 defects=0}
 def download
    begin
      path = File.expand_path("/opt/wwwdata/assets/" + params[:asset_name].to_s)
      if path.start_with?("/opt/wwwdata/assets/")
        # Compliant: 'path' is sanitized before passing in send_file.
        send_file path, disposition: "attachment"
      else
         head 403
      end
    rescue
      redirect_to "/home"
    end
 end
 # {/fact}