#!/bin/bash

# {fact rule=shell-expr-modernization defects=1}

# Noncompliant: `expr` is antiquated and can be slower.
count=$(expr $count + 1)

# {/fact}
