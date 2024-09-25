#!/bin/bash

# {fact rule=non-portable-character-class@v1.0 defects=0}

# Compliant: Uses `[:upper:]` and `[:lower:]` to properly handle all case conversions.
uppercase_name=$(echo "JOSE" | tr '[:upper:]' '[:lower:]' | tr '[:lower:]' '[:upper:]')

# {/fact}
