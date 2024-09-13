#!/bin/bash

# {fact rule=shell-sudo-redirect-misuse defects=0}

# Compliant: Uses `tee` to write with `sudo` privileges.
echo "New setting" | sudo tee /etc/myapp/settings.conf > /dev/null

# {/fact}
