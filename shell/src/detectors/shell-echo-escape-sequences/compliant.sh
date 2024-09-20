#!/bin/bash
	 
# {fact rule=shell-echo-escape-sequences defects=0}

# Compliant: `printf` interprets `\n` as a newline, properly formatting the output.
printf "First line\nSecond line\n"

# {/fact}
