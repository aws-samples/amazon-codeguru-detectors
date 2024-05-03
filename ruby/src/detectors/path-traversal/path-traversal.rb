=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=path-traversal@v1.0 defects=1}
def render_modern_param_noncompliant
    page = params[:page]
    # Noncompliant: Unsanitized user-input is used in render file.
    render file: "/some/path/#{page}"
end
# {/fact}

# {fact rule=path-traversal@v1.0 defects=0}
def render_modern_param_compliant
    page = params[:page]
    # Compliant: User-input is sanitized before using it in render file.
    render file: File.basename("/some/path/#{page}")
end
# {/fact}
