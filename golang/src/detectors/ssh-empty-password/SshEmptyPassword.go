package main

import (
    "log"
    "os"

    "golang.org/x/crypto/ssh"
    "golang.org/x/crypto/ssh/knownhosts"
)

// {fact rule=improper-authentication@v1.0 defects=1}
func sshEmptyPasswordNoncompliant() {
    // ssh config
    customHostKeyCallback, err := knownhosts.New("/home/username/.ssh/known_hosts")
    if err != nil {
        log.Fatal("Error initializing host key callback:", err)
    }
    sshConfig := &ssh.ClientConfig{
        User: "exampleuser",
        Auth: []ssh.AuthMethod{
            // Noncompliant: Empty password in ssh config.
            ssh.Password(""),
        },
        HostKeyCallback: customHostKeyCallback,
    }

    _, err = ssh.Dial("tcp", "192.168.1.100:22", sshConfig)
    if err != nil {
        log.Fatal("Failed to dial: ", err)
    }
}
// {/fact}

// {fact rule=improper-authentication@v1.0 defects=0}
func sshEmptyPasswordCompliant() {
    customHostKeyCallback, err := knownhosts.New("/home/username/.ssh/known_hosts")
    if err != nil {
         log.Fatal("Error initializing host key callback:", err)
    }
    sshConfig := &ssh.ClientConfig{
        User: "exampleuser",
        Auth: []ssh.AuthMethod{
            // Compliant: Password is fetched from environment variable.
            ssh.Password(os.Getenv("PASSWORD")),
        },
        HostKeyCallback: customHostKeyCallback,
    }

    _, err = ssh.Dial("tcp", "192.168.1.100:22", sshConfig)
    if err != nil {
        log.Fatal("Failed to dial: ", err)
    }
}
// {/fact}
