#!/bin/bash

# {fact rule=shell-single-iteration-loop defects=0}

# Compliant: Correct usage of for loop to iterate over files.
for file in *.txt
do
    echo "Processing $file"
done

# {/fact}
