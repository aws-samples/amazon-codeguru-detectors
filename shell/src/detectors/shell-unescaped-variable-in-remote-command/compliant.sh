#!/bin/bash
	 
# {fact rule=shell-unescaped-variable-in-remote-command defects=0}

# Compliant: `\$HOME` is passed literally to the remote host, expanding to the correct remote home directory.
ssh user@remote "ls -l \$HOME/documents"

# {/fact}
