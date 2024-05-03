package util

import (
	"net/http"
)

// {fact rule=insecure-cookie@v1.0 defects=1}
func httpCookieSecureNotsetNoncompliant(w http.ResponseWriter, name, value string) {
	// Noncompliant: `Secure` not set
	cookie := http.Cookie{
		HttpOnly: true,
		Name:     name,
		Value:    value,
	}
	http.SetCookie(w, &cookie)
}

// {/fact}

// {fact rule=insecure-cookie@v1.0 defects=0}
func httpCookieSecureNotsetCompliant(w http.ResponseWriter, name, value string) {
	// Noncompliant: `Secure` set true
	cookie := http.Cookie{
		Secure:   true,
		HttpOnly: true,
		Name:     name,
		Value:    value,
	}
	http.SetCookie(w, &cookie)
}

// {/fact}
