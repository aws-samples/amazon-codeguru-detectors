package main

import (
    "net/http"
)

// {fact rule=insecure-connection@v1.0 defects=1}
func httpListenandservetlsNoncompliant() {
    handler := func(w http.ResponseWriter, r *http.Request) {
        w.Header().Set("Content-Type", "text/plain")
        w.Write([]byte("Hello!"))
    }
    http.HandleFunc("/test", handler)
    // Noncompliant: http.ListenAndServe is used (without certificate and key)
    http.ListenAndServe("192.168.1.101:2000", nil)
}
// {/fact}

// {fact rule=insecure-connection@v1.0 defects=0}
func httpListenandservetlsCompliant(certFile string, keyFile string) {
    handler := func(w http.ResponseWriter, r *http.Request) {
        w.Header().Set("Content-Type", "text/plain")
        w.Write([]byte("Hello!"))
    }
    http.HandleFunc("/test", handler)
    // Compliant: `http.ListenAndServeTLS` is used (with certificate and key)
    http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, nil)
}
// {/fact}