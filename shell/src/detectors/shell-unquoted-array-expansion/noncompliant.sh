#!/bin/bash

# {fact rule=unquoted-array-expansion@v1.0 defects=1}

# Noncompliant: Unquoted array expansion can lead to word splitting and globbing.
rm $@

# {/fact}
