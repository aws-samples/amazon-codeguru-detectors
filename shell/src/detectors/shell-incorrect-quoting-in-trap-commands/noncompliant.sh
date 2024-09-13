#!/bin/bash

# {fact rule=shell-incorrect-quoting-in-trap-commands defects=1}

# Vulnerable: Double quotes cause immediate expansion of the date command.
trap "echo \"Script finished at $(date)\"" EXIT

# {/fact}
