#!/bin/bash

# {fact rule=shell-unquoted-array-expansion defects=1}

# Noncompliant: Unquoted array expansion can lead to word splitting and globbing.
rm $@

# {/fact}
