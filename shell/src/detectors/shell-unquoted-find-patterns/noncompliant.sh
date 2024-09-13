#!/bin/bash

# {fact rule=unquoted-find-patterns@v1.0 defects=1}

# Noncompliant: Unquoted parameter can lead to unexpected behavior if files matching the pattern exist in the current directory.
find . -name *.log

# {/fact}
