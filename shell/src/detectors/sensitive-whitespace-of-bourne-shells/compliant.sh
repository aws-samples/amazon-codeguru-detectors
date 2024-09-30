#!/bin/bash

# {fact rule=sensitive-whitespace-of-bourne-shells@v1.0 defects=0}

# Compliant: Correct spacing allows proper parsing of the conditional expression.
while [[ "$COUNT" -lt 10 ]]; do
  echo "$COUNT"
  ((COUNT++))
done

# {/fact}
