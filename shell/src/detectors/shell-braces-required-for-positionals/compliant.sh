#!/bin/bash
	 
# {fact rule=shell-braces-required-for-positionals defects=0}

# Compliant: Uses `${11}` which is properly referencing the 11th argument.
echo "The 11th argument is ${11}"

# {/fact}
