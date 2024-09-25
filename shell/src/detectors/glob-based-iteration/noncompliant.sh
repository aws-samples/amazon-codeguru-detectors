#!/bin/bash

# {fact rule=glob-based-iteration@v1.0 defects=1}

# Noncompliant: This will fail for filenames with spaces or special characters.
for img in $(ls *.jpg)
do
    convert "$img" "${img%.jpg}.png"
done

# {/fact}
