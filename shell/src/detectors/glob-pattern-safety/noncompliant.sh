#!/bin/bash

# {fact rule=glob-pattern-safety@v1.0 defects=1}

# Noncompliant: Can accidentally delete files with names starting with '-'.
rm *

# {/fact}
