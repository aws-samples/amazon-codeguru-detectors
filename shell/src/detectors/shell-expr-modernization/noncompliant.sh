#!/bin/bash

# {fact rule=expr-modernization@v1.0 defects=1}

# Noncompliant: `expr` is antiquated and can be slower.
count=$(expr $count + 1)

# {/fact}
