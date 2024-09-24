#!/bin/bash

# {fact rule=read-lines-with-while-loop@v1.0 defects=1}

# Noncompliant: Word splitting and glob expansion can break on special characters.
echo "Processing lines from file.txt:"
for line in $(cat file.txt | grep -v '^#')
do
    echo "Processing: $line"
done

# {/fact}
