#!/bin/bash

# {fact rule=unquoted-tr-arguments@v1.0 defects=0}

# Compliant: Quoted `tr` parameters prevent glob expansion, ensuring correct character class usage.
echo "Hello, World!" | tr '[:lower:]' '[:upper:]'

# {/fact}
