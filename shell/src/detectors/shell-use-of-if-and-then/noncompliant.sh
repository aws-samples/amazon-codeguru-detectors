# {fact rule=shell-use-of-if-and-then defects=1}

if [ grep -q pattern file ]
then
  echo "Found a match"
fi

# {/fact}
