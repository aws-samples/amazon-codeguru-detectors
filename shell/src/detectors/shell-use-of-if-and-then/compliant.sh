#!/bin/bash

# {fact rule=shell-use-of-if-and-then defects=0}

# Compliant: Directly uses the command in the `if` statement.
if ls -l /etc/passwd
then
    echo "Successfully listed /etc/passwd"
else
    echo "Failed to list /etc/passwd"
fi

# {/fact}
