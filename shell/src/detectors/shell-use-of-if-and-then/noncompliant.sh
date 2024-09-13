#!/bin/bash

# {fact rule=shell-use-of-if-and-then defects=1}

# Noncompliant: Incorrectly uses test brackets around a command.
if [ ls -l /etc/passwd ]
then
    echo "Successfully listed /etc/passwd"
else
    echo "Failed to list /etc/passwd"
fi

# {/fact}
