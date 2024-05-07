package main

import "fmt"

// {fact rule=useless-if-body@v1.0 defects=1}
func uselessIfBodyNoncompliant(num int){
	// Noncompliant: Both `if` and `else` have same body.
	if num == 3 {
		fmt.Println("Hello")
	} else {
		fmt.Println("Hello")
	}
}
// {/fact}

// {fact rule=useless-if-body@v1.0 defects=0}
func uselessIfBodyCompliant(num int){
	// Compliant: `if` and `else` have different body.
	if num == 3 {
		fmt.Println("Hello")
	} else {
	    fmt.Println("Bye")
	}
}
// {/fact}
