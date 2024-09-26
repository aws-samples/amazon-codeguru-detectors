#!/bin/bash

# {fact rule=unescaped-variable@v1.0 defects=1}

# Noncompliant: Surrounding quotes unintentionally unquote the variable expansion.
message="Welcome to "$USER"'s home directory"
echo $message

# {/fact}
