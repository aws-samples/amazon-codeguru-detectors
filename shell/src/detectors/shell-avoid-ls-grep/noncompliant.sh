#!/bin/bash

# {fact rule=shell-avoid-ls-grep defects=1}

# Noncompliant: `ls | grep` can break with special characters in filenames.
echo "Files containing 'config' in the current directory:"
ls | grep config

# {/fact}
