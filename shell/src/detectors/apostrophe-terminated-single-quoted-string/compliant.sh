#!/bin/bash

# {fact rule=apostrophe-terminated-single-quoted-string@v1.0 defects=0}

# Compliant: Escaping the apostrophes allows them to be included in the single-quoted string.
echo 'I can'\''t believe it'\''s not butter!'

# {/fact}