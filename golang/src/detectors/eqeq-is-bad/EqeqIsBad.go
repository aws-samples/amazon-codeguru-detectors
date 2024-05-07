package main

import "fmt"

// {fact rule=best-practices@v1.0 defects=1}
func eqeqIsBadNoncompliant() {
	var s = "hello World !"
	// Noncompliant: redundant comparison operation is used.
	if s == s {
		fmt.Println(s)
	}
}

// {/fact}

// {fact rule=best-practices@v1.0 defects=0}
func eqeqIsBadCompliant() {
	var s = "hello World !"
	// Compliant:  redundant comparison operation is not used.
	fmt.Println(s)
}

// {/fact}
