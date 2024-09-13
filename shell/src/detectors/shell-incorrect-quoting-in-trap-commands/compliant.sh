#!/bin/bash

# {fact rule=shell-incorrect-quoting-in-trap-commands defects=0}

# Compliant: Single quotes delay expansion until the `trap` is triggered
trap 'echo "Script finished at $(date)"' EXIT

# {/fact}
