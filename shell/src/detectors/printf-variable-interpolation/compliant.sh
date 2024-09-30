#!/bin/bash

# {fact rule=printf-variable-interpolation@v1.0 defects=0}

# Compliant: Safely handles variables, even if they contain format specifiers.
name="Alice"
printf "Welcome, %s!\n" "$name"

# {/fact}
