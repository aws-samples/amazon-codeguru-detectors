#!/bin/bash

# {fact rule=command-substitution-execution@v1.0 defects=0}

# Compliant: Simply runs the 'ls' command without trying to execute its output
ls -l /tmp

# {/fact}