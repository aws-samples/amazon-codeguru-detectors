#!/bin/bash

# {fact rule=single-iteration-loop@v1.0 defects=0}

# Compliant: Correct usage of for loop to iterate over files.
for file in *.txt
do
    echo "Processing $file"
done

# {/fact}
