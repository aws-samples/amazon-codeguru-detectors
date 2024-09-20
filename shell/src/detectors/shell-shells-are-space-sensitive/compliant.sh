#!/bin/bash
	 
# {fact rule=shell-shells-are-space-sensitive defects=0}

# Compliant: `< <(cmd)` properly separates input redirection from process substitution, allowing correct execution.
while read -r line; do
    echo "$line"
done < <(tail -f /var/log/syslog)

# {/fact}
