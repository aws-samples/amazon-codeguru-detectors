#!/bin/bash

# {fact rule=find-loop-safety@v1.0 defects=1}

# Noncompliant: This will fail for filenames containing spaces or special characters.
for file in $(find ./documents -type f -name "*.txt")
do
    echo "Processing: $file"
    wc -l "$file"
done

# {/fact}
