#!/bin/bash

# {fact rule=shell-unnecessary-variable-expansion defects=0}

# Compliant: Simplified arithmetic expression without $
total=$((count + offset))

# {/fact}
