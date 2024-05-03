package main

import "fmt"

// {fact rule=nil-pointer-dereference@v1.0 defects=1}
func nilPointerDereferenceNoncompliant() {
    var ptr *int
    // Noncompliant: Accessing memory address that is not initialized.
    fmt.Println(*ptr)
}
// {/fact}

// {fact rule=nil-pointer-dereference@v1.0 defects=0}
func nilPointerDereferenceCompliant() {
    var ptr *int
    if ptr != nil {
        // Compliant: Nil check before accessing memory address.
        fmt.Println(*ptr)
    } else {
        fmt.Println("Pointer is nil")
    }
}
// {/fact}
