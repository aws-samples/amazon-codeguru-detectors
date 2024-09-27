#!/bin/bash

# {fact rule=sudo-redirect-misuse@v1.0 defects=1}

# Noncompliant: `sudo` doesn't affect redirections, so this fails to write.
sudo echo "New setting" > /etc/myapp/settings.conf

# {/fact}
