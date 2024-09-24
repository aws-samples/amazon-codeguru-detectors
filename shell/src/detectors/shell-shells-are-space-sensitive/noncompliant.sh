#!/bin/bash
	 
# {fact rule=shells-are-space-sensitive@v1.0 defects=1}

# Noncompliant: `<<(cmd)` is invalid.
while read -r line; do
    echo "$line"
done <<(tail -f /var/log/syslog)

# {/fact}
