#!/bin/bash

# {fact rule=sensitive-whitespace-of-bourne-shells@v1.0 defects=1}

# Noncompliant: Missing space after `[[` in conditional expression.
while [["$COUNT" -lt 10 ]]; do
  echo "$COUNT"
  ((COUNT++))
done

# {/fact}
