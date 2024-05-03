package main

import (
	"crypto/tls"
	"net/http"
)

// {fact rule=improper-certificate-validation@v1.0 defects=1}
func improperCertificateValidationNoncompliant(authReq *http.Request) *http.Response {
	// Noncompliant: `InsecureSkipVerify` parameter set to true
	tr := &http.Transport{
		TLSClientConfig: &tls.Config{
			InsecureSkipVerify: true,
			MinVersion:         tls.VersionTLS13,
		},
	}
	client := &http.Client{Transport: tr}
	res, _ := client.Do(authReq)
	return res
}
// {/fact}

// {fact rule=improper-certificate-validation@v1.0 defects=0}
func improperCertificateValidationCompliant(authReq *http.Request) *http.Response {
	// Compliant: `InsecureSkipVerify` parameter set to false
	tr := &http.Transport{
		TLSClientConfig: &tls.Config{
			InsecureSkipVerify: false,
			MinVersion:         tls.VersionTLS13,
		},
	}
	client := &http.Client{Transport: tr}
	res, _ := client.Do(authReq)
	return res
}
// {/fact}
