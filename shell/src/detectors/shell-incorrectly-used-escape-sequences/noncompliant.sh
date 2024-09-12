#!/bin/bash

# {fact rule=shell-incorrectly-used-escape-sequences defects=1}

# Noncompliant: Attempt to create a CSV-like output with tabs.
output=Name\tAge\tCity
echo "$output"

# {/fact}
