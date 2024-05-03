package main

import (
    "fmt"
    "io"
    "net"
)

// {fact rule=sensitive-information-leak@v1.0 defects=1}
func bindToAllInterfacesNoncompliant() {
	// Noncompliant: `0.0.0.0` IP address used
	tel, err := net.Listen("tcp", "0.0.0.0:2000")
    if err != nil {
        fmt.Println(err)
        return
    }

    for {
        conn, err := tel.Accept()
        if err != nil {
            break
        }
        go func(c net.Conn) {
            io.Copy(c, c)
            c.Close()
        }(conn)
    }
}
// {/fact}

// {fact rule=sensitive-information-leak@v1.0 defects=0}
func bindToAllInterfacesCompliant() {
	// Compliant: `192.168.1.101` IP address used
	tel, err := net.Listen("tcp", "192.168.1.101:2000")
    if err != nil {
        fmt.Println(err)
        return
    }

    for {
        conn, err := tel.Accept()
        if err != nil {
            break
        }
        go func(c net.Conn) {
            io.Copy(c, c)
            c.Close()
        }(conn)
    }
}
// {/fact}
