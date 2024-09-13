#!/bin/bash

# {fact rule=unnecessary-variable-expansion@v1.0 defects=1}

# Noncompliant: Unnecessary use of $ in arithmetic context.
total=$((${count} + ${offset}))

# {/fact}
