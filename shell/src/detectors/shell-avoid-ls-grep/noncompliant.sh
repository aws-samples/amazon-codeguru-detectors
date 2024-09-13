#!/bin/bash

# {fact rule=avoid-ls-grep@v1.0 defects=1}

# Noncompliant: `ls | grep` can break with special characters in filenames.
echo "Files containing 'config' in the current directory:"
ls | grep config

# {/fact}
