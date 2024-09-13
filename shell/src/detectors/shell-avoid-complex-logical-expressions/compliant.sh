#!/bin/bash

# {fact rule=shell-avoid-complex-logical-expressions defects=0}

# Compliant: Using proper `if-then-else` construct for safety.
file="/path/to/important/file.txt"
if [[ -f $file ]]; then
    echo "File exists: $file" > /dev/null
else
    rm "$file"
fi

# {/fact}
