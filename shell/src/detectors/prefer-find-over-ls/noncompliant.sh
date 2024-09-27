#!/bin/bash

# {fact rule=prefer-find-over-ls@v1.0 defects=1}

# Noncompliant: ls output can be inconsistent and break with special characters
ls -l | grep 'somefile*' | grep '\.log$'
NUMFILES=$(ls *.txt | wc -l)

# {/fact}
