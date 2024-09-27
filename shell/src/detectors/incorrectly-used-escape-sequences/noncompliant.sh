#!/bin/bash

# {fact rule=incorrectly-used-escape-sequences@v1.0 defects=1}

# Noncompliant: Attempt to create a CSV-like output with tabs.
output=Name\tAge\tCity
echo "$output"

# {/fact}
