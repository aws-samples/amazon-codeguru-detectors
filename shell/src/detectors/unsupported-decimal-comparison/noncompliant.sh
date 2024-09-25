#!/bin/bash

# {fact rule=unsupported-decimal-comparison@v1.0 defects=1}

# Noncompliant: Using test command with decimal numbers.
if [ 0.5 -eq 0.50 ]; then
    echo "The numbers are equal"
fi

# {/fact}
