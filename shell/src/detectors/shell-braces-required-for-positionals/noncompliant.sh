#!/bin/bash
	 
# {fact rule=shell-braces-required-for-positionals defects=1}

# Noncompliant: Uses `$11`, which will be interpreted as `$1` followed by 1 or 0.
echo "The 11th argument is $11"

# {/fact}
