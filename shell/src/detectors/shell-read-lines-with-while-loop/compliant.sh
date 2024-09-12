#!/bin/bash

# {fact rule=shell-read-lines-with-while-loop defects=0}

# Compliant: while read loop preserves whitespace and handles special characters.
echo "Processing lines from file.txt:"
while IFS= read -r line
do
    [[ $line =~ ^# ]] && continue
    echo "Processing: $line"
done < file.txt

# {/fact}
