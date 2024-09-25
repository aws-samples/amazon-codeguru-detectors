#!/bin/bash

# {fact rule=incorrect-redirection-order@v1.0 defects=1}

# Noncompliant: stderr redirected to original stdout, then stdout redirected to file.
ls -l /nonexistent 2>&1 > output.txt

# {/fact}
