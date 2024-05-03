package main

import (
	"fmt"
	"os"
)

// {fact rule=insecure-file-permissions@v1.0 defects=1}
func insecureFilePermissionsNoncompliant() {
	// Noncompliant: `0777` grants read, write and execute permission to owner, group and others.
	err := os.Chmod("/project/src/information.txt", 0777)
	if err != nil {
		fmt.Println("Error occurred while changing file permission:", err)
		return
	}
	fmt.Println("File permission changed successfully.")
}
// {/fact}

// {fact rule=insecure-file-permissions@v1.0 defects=0}
func insecureFilePermissionsCompliant() {
	// Compliant: File permissions is set to `0400` which provides read permission to file owner only.
	err := os.Chmod("/project/src/information.txt", 0400)
	if err != nil {
		fmt.Println("Error occurred while changing file permission:", err)
		return
	}
	fmt.Println("File permission changed successfully.")
}
// {/fact}
