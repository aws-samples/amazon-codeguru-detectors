package main

import (
	net "net/http"
)

// {fact rule=path-traversal@v1.0 defects=1}
func dirTraversalNoncompliant() {
    // Noncompliant: Mounting the root directory '/' with `http.Dir`.
	d := net.Dir("/")
	f, err := d.Open("some file")
	if err != nil {
		panic(err)
	}
	defer f.Close()
}
// {/fact}

// {fact rule=path-traversal@v1.0 defects=0}
func dirTraversalCompliant() {
    // Compliant: Not mounting the root directory '/' with `http.Dir`.
	d := net.Dir("/dir/newdir")
	f, err := d.Open("some file")
	if err != nil {
		panic(err)
	}
	defer f.Close()
}
// {/fact}