package main

import (
	"golang.org/x/crypto/ssh"
	"log"
)

// {fact rule=insecure-ignore-host-key@v1.0 defects=1}
func insecureIgnoreHostKeyNoncompliant() {
    // Noncompliant: `ssh.InsecureIgnoreHostKey()` disables trusted host validation.
	config := &ssh.ClientConfig{
		User:            "name",
		Timeout:         1000,
		Auth:            []ssh.AuthMethod{},
		HostKeyCallback: ssh.InsecureIgnoreHostKey(),
	}
	conn, err := ssh.Dial("tcp", "192.168.1.101:2000", config)
	if err != nil {
		log.Println(err)
	}
	defer conn.Close()
}
// {/fact}

// {fact rule=insecure-ignore-host-key@v1.0 defects=0}
func insecureIgnoreHostKeyCompliant(key ssh.PublicKey) {
    // Compliant: Used `ssh.ClientConfig`'s `HostKeyCallback`.
	config := &ssh.ClientConfig{
		User:            "name",
		Timeout:         1000,
		Auth:            []ssh.AuthMethod{},
		HostKeyCallback: ssh.FixedHostKey(key),
    }
	conn, err := ssh.Dial("tcp", "192.168.1.101:2000", config)
	if err != nil {
		log.Println(err)
	}
	defer conn.Close()
}
// {/fact}