#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

from flask import Flask, request, abort, session

app = Flask(__name__)
app.secret_key = 'some_secret_key'

def perform_sensitive_operation():
    pass

# {fact rule=incorrect-authorization@v1.0 defects=1}
@app.route('/noncompliant')
def incorrect_authorization_noncompliant():
    # Noncompliant: Authorization is based on a cookie, which can be easily manipulated by an anonymous user.
    role = request.cookies.get('role')
    if role == 'Admin':
        perform_sensitive_operation()
    return "Operation completed"
# {/fact}


# {fact rule=incorrect-authorization@v1.0 defects=0}
@app.route('/compliant')
def incorrect_authorization_compliant():
    role = session.get('role')
    # Compliant: Authorization is based on the user session, which is safer.
    if role == 'Admin':
        perform_sensitive_operation()
    else:
        abort(403, "Not authorized")
    return "Sensitive operation performed"
# {/fact}
