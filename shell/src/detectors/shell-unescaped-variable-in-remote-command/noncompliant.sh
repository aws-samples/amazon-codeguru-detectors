#!/bin/bash
	 
# {fact rule=shell-unescaped-variable-in-remote-command defects=1}

# Noncompliant: `$HOME` expands on the client side, potentially using the wrong home directory.
ssh user@remote "ls -l $HOME/documents"

# {/fact}
