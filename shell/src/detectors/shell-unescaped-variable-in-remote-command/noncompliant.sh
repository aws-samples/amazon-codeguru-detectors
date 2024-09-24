#!/bin/bash
	 
# {fact rule=unescaped-variable-in-remote-command@v1.0 defects=1}

# Noncompliant: `$HOME` expands on the client side, potentially using the wrong home directory.
ssh user@remote "ls -l $HOME/documents"

# {/fact}
