#!/bin/bash

# {fact rule=shell-unquoted-find-patterns defects=1}

# Noncompliant: Unquoted parameter can lead to unexpected behavior if files matching the pattern exist in the current directory.
find . -name *.log

# {/fact}
