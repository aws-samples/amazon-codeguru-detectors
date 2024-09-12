#!/bin/bash

# {fact rule=shell-sudo-redirect-misuse defects=1}

# Noncompliant: `sudo` doesn't affect redirections, so this fails to write.
sudo echo "New setting" > /etc/myapp/settings.conf

# {/fact}
