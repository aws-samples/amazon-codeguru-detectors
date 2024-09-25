#!/bin/bash

# {fact rule=glob-based-iteration@v1.0 defects=0}

# Compliant: This correctly handles all filenames, including those with spaces or special characters.
shopt -s nullglob
for img in *.jpg
do
    [[ -e "$img" ]] || continue
    convert "$img" "${img%.jpg}.png"
done
# {/fact}
