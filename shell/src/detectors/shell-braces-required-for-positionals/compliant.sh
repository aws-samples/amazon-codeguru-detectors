#!/bin/bash
	 
# {fact rule=braces-required-for-positionals@v1.0 defects=0}

# Compliant: Uses `${11}` which is properly referencing the 11th argument.
echo "The 11th argument is ${11}"

# {/fact}
