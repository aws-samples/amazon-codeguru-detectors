#!/bin/bash

# {fact rule=unquoted-special-parameters@v1.0 defects=1}

# Noncompliant: Word splitting occurs, breaking arguments with spaces.
copy_files() {
    cp $* /backup/
}

# {/fact}
