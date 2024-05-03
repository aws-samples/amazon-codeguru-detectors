package main

import (
	"crypto/rand"
	"crypto/rsa"
	"fmt"
)

// {fact rule=deprecated-key-generator@v1.0 defects=1}
func deprecatedKeyGeneratorNoncompliant() {
	// Noncompliant: Generate Private Key with deprecated method
	pvk, err := rsa.GenerateMultiPrimeKey(rand.Reader, 3, 2048)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(pvk)
}
// {/fact}

// {fact rule=deprecated-key-generator@v1.0 defects=0}
func deprecatedKeyGeneratorCompliant() {
	// Compliant: Generate Private Key with proper method
	pvk, err := rsa.GenerateKey(rand.Reader, 2048)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(pvk)
}
// {/fact}