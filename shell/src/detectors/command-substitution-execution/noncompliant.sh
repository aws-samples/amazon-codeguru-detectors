#!/bin/bash

# {fact rule=command-substitution-execution@v1.0 defects=1}

# Noncompliant: Attempts to execute the output of 'ls' instead of running 'ls'
$(ls -l /tmp)

# {/fact}