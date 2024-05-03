package main

import (
	"log"
	"net/http"
    "strings"
)

// {fact rule=log-injection@v1.0 defects=1}
func logInjectionNoncompliant(req *http.Request) {
	username := req.URL.Query()["username"][0]
    // Noncompliant: User provided input is passed directly to log.
	log.Printf("user %s logged in.\n", username)
}
// {/fact}

// {fact rule=log-injection@v1.0 defects=0}
func logInjectionCompliant(req *http.Request) {
	username := req.URL.Query()["username"][0]
	escapedUsername := strings.ReplaceAll(username, "\n", "")
	escapedUsername = strings.ReplaceAll(escapedUsername, "\r", "")
    // Compliant: User provided input is sanitized before passing to log.
	log.Printf("user %s logged in.\n", escapedUsername)
}
// {/fact}
