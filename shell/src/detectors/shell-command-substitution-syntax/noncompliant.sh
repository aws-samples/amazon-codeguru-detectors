#!/bin/bash

# {fact rule=shell-command-substitution-syntax defects=1}

# Vulnerable: Backticks are legacy syntax and hard to nest.
current_dir=`pwd`

# {/fact}
