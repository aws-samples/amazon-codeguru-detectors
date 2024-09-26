#!/bin/bash

# {fact rule=unquoted-tr-arguments@v1.0 defects=1}

# Noncompliant: Unquoted `tr` parameters can lead to unintended glob expansion.
echo "Hello, World!" | tr [:lower:] [:upper:]

# {/fact}
