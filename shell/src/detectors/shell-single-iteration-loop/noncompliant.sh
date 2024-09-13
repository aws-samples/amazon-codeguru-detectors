#!/bin/bash

# {fact rule=shell-single-iteration-loop defects=1}

# Noncompliant: This loop will only run once.
for file in myfile.txt
do
    echo "Processing $file"
done

# {/fact}
