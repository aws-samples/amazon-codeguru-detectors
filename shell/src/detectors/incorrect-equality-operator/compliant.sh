#!/bin/bash

# {fact rule=incorrect-equality-operator@v1.0 defects=0}

# Compliant: Proper assignment using single `=`.
count=0
while [ $count -lt 5 ]; do
    echo $count
    count=$((count + 1))
done

# {/fact}
