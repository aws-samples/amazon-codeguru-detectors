#!/bin/bash

# {fact rule=incorrect-redirection-order@v1.0 defects=0}

# Compliant: stdout redirected to file, then stderr redirected to new stdout (file).
ls -l /nonexistent > output.txt 2>&1

# {/fact}
