#!/bin/bash

# {fact rule=use-of-if-and-then@v1.0 defects=0}

# Compliant: Directly uses the command in the `if` statement.
if ls -l /etc/passwd
then
    echo "Successfully listed /etc/passwd"
else
    echo "Failed to list /etc/passwd"
fi

# {/fact}
