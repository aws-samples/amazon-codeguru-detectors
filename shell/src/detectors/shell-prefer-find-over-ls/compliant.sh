#!/bin/bash

# {fact rule=prefer-find-over-ls@v1.0 defects=0}

# Compliant: find handles special characters and provides consistent output
find . -type f -name '*.log' -exec ls -l {} + | grep 'somefile*'
numfiles=$(find . -type f -name '*.txt' | wc -l)

# {/fact}
