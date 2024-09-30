#!/bin/bash

# {fact rule=constant-comparison@v1.0 defects=0}

# Compliant: Correctly compares the value of `$count` with `5`
if [ "$count" -eq 5 ]
then
  echo "Count is 5"
fi

# {/fact}