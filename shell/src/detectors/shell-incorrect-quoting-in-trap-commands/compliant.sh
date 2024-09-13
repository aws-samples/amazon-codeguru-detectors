#!/bin/bash

# {fact rule=incorrect-quoting-in-trap-commands@v1.0 defects=0}

# Compliant: Single quotes delay expansion until the `trap` is triggered
trap 'echo "Script finished at $(date)"' EXIT

# {/fact}
