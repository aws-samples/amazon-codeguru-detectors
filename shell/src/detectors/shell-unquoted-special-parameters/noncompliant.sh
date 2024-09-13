#!/bin/bash

# {fact rule=shell-unquoted-special-parameters defects=1}

# Noncompliant: Word splitting occurs, breaking arguments with spaces.
copy_files() {
    cp $* /backup/
}

# {/fact}
