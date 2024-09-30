#!/bin/bash

# {fact rule=incorrect-quoting-in-trap-commands@v1.0 defects=1}

# Noncompliant: Double quotes cause immediate expansion of the date command.
trap "echo \"Script finished at $(date)\"" EXIT

# {/fact}
