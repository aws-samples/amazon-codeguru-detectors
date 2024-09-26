#!/bin/bash

# {fact rule=unquoted-rhs-comparison@v1.0 defects=1}

# Noncompliant: Unquoted variable on RHS can cause issues with special characters.
password="my[pass]word"
if [[ $entered_password = $password ]]; then
    echo "Password correct"
fi

# {/fact}
