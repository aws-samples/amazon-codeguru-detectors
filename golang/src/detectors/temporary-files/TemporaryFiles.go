package main

import (
	"fmt"
	"os"
)

// {fact rule=temporary-files@v1.0 defects=1}
func temporaryFilesNoncompliant() {
	// Noncompliant: File creation in shared tmp directory without using `os.CreateTemp`.
	file, err := os.Create("/tmp/file")
	if err != nil {
		fmt.Println("Error occurred during file creation")
	}
	defer file.Close()
}

// {/fact}

// {fact rule=temporary-files@v1.0 defects=0}
func temporaryFilesCompliant() {
	// Compliant: File creation in shared tmp directory with using `os.CreateTemp`.
	file, err := os.CreateTemp("/tmp", "file")
	if err != nil {
		fmt.Println("Error occurred during file creation")
	}
	defer file.Close()
}

// {/fact}
