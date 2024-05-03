package main

import (
	"fmt"
	"log"
	"net/http"
	_ "net/http/pprof"
)

// {fact rule=pprof-endpoint@v1.0 defects=1}
func pprofDebugExposureNoncompliant() {
	http.HandleFunc("/healthz", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Not Ok")
	})
	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	// Noncompliant: pprof is enabled.
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, nil))
}

// {/fact}

// {fact rule=pprof-endpoint@v1.0 defects=0}
func pprofDebugExposureCompliant() {
	http.HandleFunc("/healthz", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintf(w, "Ok")
	})
	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	serveMux := http.NewServeMux()
	// Compliant: pprof is disabled.
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, serveMux))
}

// {/fact}
