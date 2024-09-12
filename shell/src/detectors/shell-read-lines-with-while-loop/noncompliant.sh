#!/bin/bash

# {fact rule=shell-read-lines-with-while-loop defects=1}

# Noncompliant: Word splitting and glob expansion can break on special characters.
echo "Processing lines from file.txt:"
for line in $(cat file.txt | grep -v '^#')
do
    echo "Processing: $line"
done

# {/fact}
