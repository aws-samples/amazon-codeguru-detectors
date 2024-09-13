#!/bin/bash

# {fact rule=unnecessary-variable-expansion@v1.0 defects=0}

# Compliant: Simplified arithmetic expression without $
total=$((count + offset))

# {/fact}
