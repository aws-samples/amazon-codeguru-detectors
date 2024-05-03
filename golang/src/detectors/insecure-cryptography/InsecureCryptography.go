package main

import (
	"crypto/md5"
	"crypto/sha256"
	"fmt"
)

type User struct {
	password string
}

func (user *User) setPassword(password string) {
	user.password = password
}

// {fact rule=insecure-cryptography@v1.0 defects=1}
func insecureCryptographyNoncompliant(user *User, passText string) {
	data := []byte(passText)
	// Noncompliant: md5 used as password.
	hash := md5.Sum(data)
	password := fmt.Sprintf("%x", hash)
	user.setPassword(password)
}

// {/fact}

// {fact rule=insecure-cryptography@v1.0 defects=0}
func insecureCryptographyCompliant(user *User, passText string) {
	data := []byte(passText)
	// Compliant: sha256 used as password.
	hash := sha256.Sum256(data)
	password := fmt.Sprintf("%x", hash)
	user.setPassword(password)
}

// {/fact}
