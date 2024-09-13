#!/bin/bash

# {fact rule=shell-ps-grep-alternative defects=0}

# Compliant: Using `pgrep` instead of grepping `ps` output.
if pgrep -x "apache2" > /dev/null; then
    echo "Apache is running"
else
    echo "Apache is not running"
fi

# {/fact}
