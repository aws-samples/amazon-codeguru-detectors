#!/bin/bash

# {fact rule=shell-unquoted-special-parameters defects=0}

# Compliant: Preserves arguments with spaces.
copy_files() {
    cp "$@" /backup/
}

# {/fact}
