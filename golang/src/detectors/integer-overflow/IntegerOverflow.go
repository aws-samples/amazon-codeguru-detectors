package main

import (
	"fmt"
	"strconv"
)

// {fact rule=integer-overflow@v1.0 defects=1}
func integerOverflowNoncompliant() {
	value, err := strconv.Atoi("-2147483649")
	if err != nil {
		panic(err)
	}
	// Noncompliant: `int32` used with big value.
	newValue := int32(value)
	fmt.Println(newValue)
}
// {/fact}

// {fact rule=integer-overflow@v1.0 defects=0}
func integerOverflowCompliant() {
	value, err := strconv.Atoi("2147483647")
	if err != nil {
		panic(err)
	}
	// Compliant:  `int32` used with small value.
	newValue := int32(value)
	fmt.Println(newValue)
}
// {/fact}