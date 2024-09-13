#!/bin/bash

# {fact rule=incorrectly-used-escape-sequences@v1.0 defects=0}

# Compliant: Correctly create a CSV-like output with tabs.
output="Name$(printf '\t')Age$(printf '\t')City"
echo "$output"

# {/fact}
