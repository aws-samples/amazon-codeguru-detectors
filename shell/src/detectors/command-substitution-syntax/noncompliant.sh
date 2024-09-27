#!/bin/bash

# {fact rule=command-substitution-syntax@v1.0 defects=1}

# Noncompliant: Backticks are legacy syntax and hard to nest.
current_dir=`pwd`

# {/fact}
