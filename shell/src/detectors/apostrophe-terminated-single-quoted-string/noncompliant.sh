#!/bin/bash

# {fact rule=apostrophe-terminated-single-quoted-string@v1.0 defects=1}

# Noncompliant: Apostrophe terminates the string prematurely, causing a syntax error.
echo 'I can't believe it's not butter!'

# {/fact}