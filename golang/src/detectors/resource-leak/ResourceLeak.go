package main

import (
   "fmt"
   "log"
   "os"
)

// {fact rule=resource-leak@v1.0 defects=1}
func resourceLeakNoncompliant() {
    // Noncompliant: File is not closed properly.
    file, err := os.Open("data.txt")
    if err != nil {
        log.Fatal(err)
    }

    data := make([]byte, 1024)
    _, err = file.Read(data)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Println("Data processing complete.")
}
// {/fact}

// {fact rule=resource-leak@v1.0 defects=0}
func resourceLeakCompliant() {
    // Compliant: File is closed properly.
    file, err := os.Open("data.txt")
    if err != nil {
        log.Fatal(err)
    }
    defer file.Close()

    data := make([]byte, 1024)
    _, err = file.Read(data)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Println("Data processing complete.")
}
// {/fact}
