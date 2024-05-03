package main

import (
	"fmt"
	"html"
	"net/http"
)

// {fact rule=cross-site-request-forgery@v1.0 defects=1}
func crossSiteRequestForgeryNoncompliant(w http.ResponseWriter, r *http.Request) {
	// Noncompliant: Sending a POST request with user input without CSRF protection.
	fmt.Fprintf(w, "Go to: %s", html.EscapeString(r.URL.Path))
}

// {/fact}

// {fact rule=cross-site-request-forgery@v1.0 defects=0}
func crossSiteRequestForgeryCompliant(w http.ResponseWriter, r *http.Request, csrfToken string) {
	csrfTokenFromForm := r.FormValue("csrf_token")
	if csrfTokenFromForm != csrfToken {
		http.Error(w, "Invalid CSRF token", http.StatusForbidden)
		return
	}

	// Compliant: Sending a POST request with user input with CSRF protection.
	fmt.Fprintf(w, "Go to: %s", html.EscapeString(r.URL.Path))
}

// {/fact}
