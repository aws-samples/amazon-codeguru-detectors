#!/bin/bash

# {fact rule=shell-prefer-find-over-ls defects=1}

# Noncompliant: ls output can be inconsistent and break with special characters
ls -l | grep 'somefile*' | grep '\.log$'
NUMFILES=$(ls *.txt | wc -l)

# {/fact}
