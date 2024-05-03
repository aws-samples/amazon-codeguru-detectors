package main

import (
    "fmt"
    "net/http"
)

// {fact rule=server-side-request-forgery@v1.0 defects=1}
func taintedUrlHostNoncompliant (w http.ResponseWriter, r *http.Request) {
    urls, ok := r.URL.Query()["url"]
    if !ok || len(urls) == 0 {
        http.Error(w, "Missing url parameter", http.StatusBadRequest)
        return
    }
    url := fmt.Sprintf("//%s/path/to/folder", urls[0])
    client := &http.Client {}

    // Noncompliant: the host part of the URL is tainted.
    req, err := http.NewRequest("GET", url, nil)
    if err != nil {
        http.Error(w, err.Error(), http.StatusInternalServerError)
        return
    }

    resp, err := client.Do(req)
    if err != nil {
        http.Error(w, err.Error(), http.StatusInternalServerError)
        return
    }
    defer resp.Body.Close()
}
// {/fact}

// {fact rule=server-side-request-forgery@v1.0 defects=0}
func taintedUrlHostCompliant (w http.ResponseWriter, r *http.Request) {
     urls, ok := r.URL.Query()["url"]
     if !ok || len(urls) == 0 {
         http.Error(w, "Missing url parameter", http.StatusBadRequest)
         return
     }
     url := "https://website.com"
     client := &http.Client {}
 	 // Compliant:  the host part of the URL is not tainted.
     req, err := http.NewRequest("GET", url, nil)
     if err != nil {
         http.Error(w, err.Error(), http.StatusInternalServerError)
         return
     }
    resp, err := client.Do(req)
    if err != nil {
        http.Error(w, err.Error(), http.StatusInternalServerError)
        return
    }
    defer resp.Body.Close()
}
// {/fact}
