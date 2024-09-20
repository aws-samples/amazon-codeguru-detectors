#!/bin/bash
	 
# {fact rule=shell-incorrect-conditional-syntax defects=0}

# Compliant: Uses `elif` for proper alternative condition checking in shell scripts.
if [ "$fruit" = "apple" ]
then
    echo "It's an apple"
elif [ "$fruit" = "banana" ]
then
    echo "It's a banana"
else
    echo "It's something else"
fi

# {/fact}
