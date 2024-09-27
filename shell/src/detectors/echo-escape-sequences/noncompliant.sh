#!/bin/bash
	 
# {fact rule=echo-escape-sequences@v1.0 defects=1}

# Noncompliant: `echo` doesn't interpret `\n` as a newline, resulting in literal output of `\n`.
echo "First line\nSecond line"

# {/fact}
