#!/bin/bash
	 
# {fact rule=shell-incorrect-conditional-syntax defects=1}

# Noncompliant: Uses `else if` which is not valid shell syntax for alternative conditions.
if [ "$fruit" = "apple" ]
then
    echo "It's an apple"
else if [ "$fruit" = "banana" ]
then
    echo "It's a banana"
else
    echo "It's something else"
fi fi

# {/fact}
