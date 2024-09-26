#!/bin/bash

# {fact rule=arithmetic-expansion-modernization@v1.0 defects=0}

# Compliant: Use the standard `$((..))` syntax for arithmetic operations.
x=5
y=3
result=$((x * y))
echo "Result: $result"

# {/fact}
