#!/bin/bash

# {fact rule=unbraced-array-expansion@v1.0 defects=0}

# Compliant: Array index accessed with braces, ensuring proper expansion.
fruits=("apple" "banana" "cherry")
echo "The second fruit is ${fruits[1]}"

# {/fact}
