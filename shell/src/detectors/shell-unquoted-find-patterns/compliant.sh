#!/bin/bash

# {fact rule=unquoted-find-patterns@v1.0 defects=0}

# Compliant: Quoted parameter ensures the pattern is passed to `find` as intended.
find . -name '*.log'

# {/fact}
