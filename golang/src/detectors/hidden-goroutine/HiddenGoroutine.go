package main

import (
	"fmt"
)

// {fact rule=hidden-goroutine@v1.0 defects=1}
func hiddenGoroutineNoncompliant() {
	// Noncompliant: Hidden goroutines inside functions.
	go func() {
		if 5%2 == 0 {
			fmt.Println("5 is even")
		} else {
			fmt.Println("5 is odd")
		}
	}()
}

// {/fact}

// {fact rule=hidden-goroutine@v1.0 defects=0}
func hiddenGoroutineCompliant() {
	// Compliant: There is other operations along with goroutine.
	if num := 17; num < 0 {
		fmt.Println(num, "is negative")
	}
	go func() {
		if 5%2 == 0 {
			fmt.Println("5 is even")
		} else {
			fmt.Println("5 is odd")
		}
	}()
	if 8%2 == 0 {
		fmt.Println("8 is even")
	}
}

// {/fact}