package main

import (
    "fmt"
)

// {fact rule=exported-loop-pointer@v1.0 defects=1}
func exportedLoopPointerNoncompliant() {
    names := []string{"Jack", "Tom", "Sam", "Mark", "John"}
    var fs []func()
    for _, name := range names {
        fs = append(fs, func() {
            // Noncompliant: Loop pointer reference is shared across iterations.
            fmt.Println(&name)
        })
    }
}
// {/fact}

// {fact rule=exported-loop-pointer@v1.0 defects=0}
func exportedLoopPointerCompliant() {
    names := []string{"Jack", "Tom", "Sam", "Mark", "John"}
    var fs []func()
    for _, name := range names {
        // Compliant: Variable `name` is copied to a new variable within the loop before exporting.
        name := name
        fs = append(fs, func() {
            fmt.Println(&name)
        })
    }
}
// {/fact}
