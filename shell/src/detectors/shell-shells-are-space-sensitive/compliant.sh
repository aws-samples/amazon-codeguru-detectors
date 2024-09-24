#!/bin/bash
	 
# {fact rule=shells-are-space-sensitive@v1.0 defects=0}

# Compliant: `< <(cmd)` properly separates input redirection from process substitution, allowing correct execution.
while read -r line; do
    echo "$line"
done < <(tail -f /var/log/syslog)

# {/fact}
