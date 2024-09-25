#!/bin/bash

# {fact rule=unescaped-variable@v1.0 defects=0}

# Compliant: Variable expansion properly included within the quoted string.
message="Welcome to $USER's home directory"
echo "$message"

# {/fact}
