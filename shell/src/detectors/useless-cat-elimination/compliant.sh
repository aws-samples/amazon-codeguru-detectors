#!/bin/bash

# {fact rule=useless-cat-elimination@v1.0 defects=0}

# Compliant: Directly using grep with file as argument, avoiding unnecessary `cat`.
grep "error" log.txt

# {/fact}
