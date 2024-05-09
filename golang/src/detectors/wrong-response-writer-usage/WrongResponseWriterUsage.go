package main

import (
	"fmt"
	"html"
	"net/http"
)

func getData() map[string]string {
	data := make(map[string]string)
	data["title"] = "Welcome to my Website."
	data["content"] = "This is the content"

	return data
}

// {fact rule=cross-site-scripting@v1.0 defects=1}
func wrongResponseWriterUsageNoncompliant(w http.ResponseWriter, templateHTML string, data map[string]string) {
	w.WriteHeader(http.StatusAccepted)
	// Noncompliant: Writes crafted data from user provided input.
	w.Write([]byte(fmt.Sprintf(templateHTML, data["title"], data["content"])))
}

// {/fact}

// {fact rule=cross-site-scripting@v1.0 defects=0}
func wrongResponseWriterUsageCompliant(w http.ResponseWriter, templateHTML string) {
	w.WriteHeader(http.StatusAccepted)
	// Compliant: Writes sanitized and constant input.
	w.Write([]byte(fmt.Sprintf(html.EscapeString(templateHTML), "This is the content")))
}

// {/fact}
