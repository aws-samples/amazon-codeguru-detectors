#!/bin/bash
	 
# {fact rule=echo-escape-sequences@v1.0 defects=0}

# Compliant: `printf` interprets `\n` as a newline, properly formatting the output.
printf "First line\nSecond line\n"

# {/fact}
