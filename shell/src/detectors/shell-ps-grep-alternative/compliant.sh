#!/bin/bash

# {fact rule=ps-grep-alternative@v1.0 defects=0}

# Compliant: Using `pgrep` instead of grepping `ps` output.
if pgrep -x "apache2" > /dev/null; then
    echo "Apache is running"
else
    echo "Apache is not running"
fi

# {/fact}
