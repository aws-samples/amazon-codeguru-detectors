#!/bin/bash

# {fact rule=glob-pattern-safety@v1.0 defects=0}

# Compliant: Safely removes all files in current directory, even those starting with '-'.
rm ./* 2>/dev/null || rm -- *

# {/fact}
