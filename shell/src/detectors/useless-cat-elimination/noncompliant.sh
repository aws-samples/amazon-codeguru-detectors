#!/bin/bash

# {fact rule=useless-cat-elimination@v1.0 defects=1}

# Noncompliant: Unnecessary use of `cat` to pipe file contents to grep.
cat log.txt | grep "error"

# {/fact}
