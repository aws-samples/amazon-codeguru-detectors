#!/bin/bash

# {fact rule=shell-unnecessary-variable-expansion defects=1}

# Noncompliant: Unnecessary use of $ in arithmetic context.
total=$((${count} + ${offset}))

# {/fact}
