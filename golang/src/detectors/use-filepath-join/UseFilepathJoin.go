package main

import (
	"fmt"
	"path"
	"path/filepath"
)

// {fact rule=best-practices@v1.0 defects=1}
func useFilepathJoinNoncompliant() {
	pathname := "YOUR_PATH"
	// Noncompliant: Uses `path.Join()` instead of `filepath.Join()`.
	fmt.Println(path.Join(path.Base(pathname), "baz"))
}

// {/fact}

// {fact rule=best-practices@v1.0 defects=0}
func useFilepathJoinCompliant() {
	pathname := "YOUR_PATH"
	// Compliant: Uses `filepath.join()`.
	fmt.Println(filepath.Join(path.Base(pathname), "baz"))
}

// {/fact}
