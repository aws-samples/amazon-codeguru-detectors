#!/bin/bash

# {fact rule=missing-do-keyword@v1.0 defects=0}

# Compliant: `do` keyword properly included in the while loop.
while [ $count -lt 10 ]
do
  echo $count
  count=$((count + 1))
done

# {/fact}
