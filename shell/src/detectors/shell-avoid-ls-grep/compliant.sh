#!/bin/bash

# {fact rule=shell-avoid-ls-grep defects=0}

# Compliant: Using glob pattern matching handles special characters safely.
echo "Files containing 'config' in the current directory:"
for file in *config*; do
    [ -e "$file" ] && echo "$file"
done

# {/fact}
