package main

import "fmt"

// {fact rule=useless-if-conditional@v1.0 defects=1}
func uselessIfConditionNoncompliant(num int){
	// Noncompliant: Both `if` have same condition.
	if num == 3 {
		fmt.Println("Hello")
	} else if num == 3 {
		fmt.Println("Bye")
	}
}
// {/fact}

// {fact rule=useless-if-conditional@v1.0 defects=0}
func uselessIfConditionCompliant(num int){
	// Compliant: No unnecessary `if` condition.
	if num == 3 {
		fmt.Println("Hello")
	}
}
// {/fact}
