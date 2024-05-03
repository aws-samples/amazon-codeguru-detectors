package main

import (
	"log"
	"net/http"
)

// {fact rule=http-trace-file-server-as-handler@v1.0 defects=1}
func httpTraceFileServerAsHandlerNoncompliant() {
	//Noncompliant: `http.FileServer` used
	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	fs := http.FileServer(http.Dir("/dir"))
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, fs))
}

// {/fact}

// {fact rule=http-trace-file-server-as-handler@v1.0 defects=0}
func httpTraceFileServerAsHandlerCompliant() {
	//Compliant: `http.FileServer` not used
	p := func(w http.ResponseWriter, _ *http.Request) {
		w.Write([]byte("<p>Hello!!!</p>"))
	}
	certFile := "YOUR_CERT_FILE"
	keyFile := "YOUR_KEY_FILE"
	mux := http.NewServeMux()
	mux.HandleFunc("/", p)
	log.Fatal(http.ListenAndServeTLS("192.168.1.101:2000", certFile, keyFile, mux))
}

// {/fact}
