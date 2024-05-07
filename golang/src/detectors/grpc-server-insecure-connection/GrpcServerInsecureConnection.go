package insecuregrpc

import (
	"crypto/x509"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials"
	"log"
	"net"
)

// {fact rule=channel-accessible-by-non-endpoint@v1.0 defects=1}
func grpcServerInsecureConnectionNoncompliant(listener net.Listener) {
	// Noncompliant: credentials are not passed to grpc.NewServer
	d := grpc.NewServer()
	err := d.Serve(listener)
	if err != nil {
		log.Println(err)
		return
	}

}
// {/fact}

// {fact rule=channel-accessible-by-non-endpoint@v1.0 defects=0}
func grpcServerInsecureConnectionCompliant(listener net.Listener, cp *x509.CertPool) {
	creds := grpc.Creds(credentials.NewClientTLSFromCert(cp, ""))
	// Compliant: credentials are passed to grpc.NewServer
	d := grpc.NewServer(creds)
	err := d.Serve(listener)
	if err != nil {
		log.Println(err)
		return
	}
}
// {/fact}