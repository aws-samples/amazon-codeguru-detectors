#!/bin/bash

# {fact rule=shell-ps-grep-alternative defects=1}

# Noncompliant: Grepping `ps` output.
if ps aux | grep -v grep | grep "apache2" > /dev/null; then
    echo "Apache is running"
else
    echo "Apache is not running"
fi

# {/fact}
