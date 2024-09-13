#!/bin/bash

# {fact rule=shell-unquoted-find-patterns defects=0}

# Compliant: Quoted parameter ensures the pattern is passed to `find` as intended.
find . -name '*.log'

# {/fact}
