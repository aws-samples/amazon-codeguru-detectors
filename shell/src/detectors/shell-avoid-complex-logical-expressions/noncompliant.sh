#!/bin/bash

# {fact rule=shell-avoid-complex-logical-expressions defects=1}

# Noncompliant: This construct can lead to unexpected behavior.
file="/path/to/important/file.txt"
[[ -f $file ]] && echo "File exists: $file" > /dev/null || rm "$file"

# {/fact}
