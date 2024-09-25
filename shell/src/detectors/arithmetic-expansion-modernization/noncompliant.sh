#!/bin/bash

# {fact rule=arithmetic-expansion-modernization@v1.0  defects=1}

# Noncompliant: Uses the deprecated `$[..]` syntax.
x=5
y=3
result=$[x * y]
echo "Result: $result"

# {/fact}
