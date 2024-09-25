#!/bin/bash

# {fact rule=missing-do-keyword@v1.0 defects=1}

# Noncompliant: Missing `do` keyword in the while loop.
while [ $count -lt 10 ]
  echo $count
  count=$((count + 1))
done

# {/fact}
