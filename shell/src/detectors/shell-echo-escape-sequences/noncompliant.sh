#!/bin/bash
	 
# {fact rule=shell-echo-escape-sequences defects=1}

# Noncompliant: `echo` doesn't interpret `\n` as a newline, resulting in literal output of `\n`.
echo "First line\nSecond line"

# {/fact}
