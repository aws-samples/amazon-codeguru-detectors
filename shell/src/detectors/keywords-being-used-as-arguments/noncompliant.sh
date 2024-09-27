#!/bin/bash

# {fact rule=keywords-being-used-as-arguments@v1.0 defects=1}

# Noncompliant: `fi` is treated as an argument to echo, not terminating the `if` statement.
if [ -f "file.txt" ]
then
  echo "File exists" fi
  echo "This always runs"

# {/fact}
