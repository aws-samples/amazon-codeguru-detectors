#!/bin/bash

# {fact rule=unquoted-special-parameters@v1.0 defects=0}

# Compliant: Preserves arguments with spaces.
copy_files() {
    cp "$@" /backup/
}

# {/fact}
