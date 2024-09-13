#!/bin/bash

# {fact rule=single-iteration-loop@v1.0 defects=1}

# Noncompliant: This loop will only run once.
for file in myfile.txt
do
    echo "Processing $file"
done

# {/fact}
