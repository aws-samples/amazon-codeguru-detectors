#!/bin/bash

# {fact rule=keywords-being-used-as-arguments@v1.0 defects=0}

# Compliant: `fi` properly terminates the `if` statement.
if [ -f "file.txt" ]
then
  echo "File exists"
fi
echo "This runs after the if statement"

# {/fact}
