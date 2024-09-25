#!/bin/bash

# {fact rule=non-portable-character-class@v1.0 defects=1}

# Noncompliant: Uses `A-Z` which doesn't support accented uppercase letters.
uppercase_name=$(echo "JOSE" | tr 'A-Z' 'a-z' | tr 'a-z' 'A-Z')

# {/fact}
