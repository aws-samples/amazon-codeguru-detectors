#!/bin/bash
	 
# {fact rule=shell-shells-are-space-sensitive defects=1}

# Noncompliant: `<<(cmd)` is invalid.
while read -r line; do
    echo "$line"
done <<(tail -f /var/log/syslog)

# {/fact}
