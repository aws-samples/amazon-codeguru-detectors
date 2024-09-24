#!/bin/bash

# {fact rule=unquoted-array-expansion@v1.0 defects=0}

# Compliant: Quoted array expansion preserves array elements with spaces and prevents globbing.
rm "$@"

# {/fact}
