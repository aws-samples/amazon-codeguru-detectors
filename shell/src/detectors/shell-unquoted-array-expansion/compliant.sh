#!/bin/bash

# {fact rule=shell-unquoted-array-expansion defects=0}

# Compliant: Quoted array expansion preserves array elements with spaces and prevents globbing.
rm "$@"

# {/fact}
