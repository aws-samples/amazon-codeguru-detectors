#!/bin/bash

# {fact rule=shell-incorrectly-used-escape-sequences defects=0}

# Compliant: Correctly create a CSV-like output with tabs.
output="Name$(printf '\t')Age$(printf '\t')City"
echo "$output"

# {/fact}
