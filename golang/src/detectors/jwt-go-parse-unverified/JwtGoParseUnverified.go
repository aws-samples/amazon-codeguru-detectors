package main

import (
    "fmt"
    "github.com/dgrijalva/jwt-go"
)

// {fact rule=protection-mechanism-failure@v1.0 defects=1}
func jwtGoParseUnverifiedNoncompliant() {
    validToken := "valid.token.string"
    // Noncompliant: `ParseUnverified` used in here.
    token, _, err := new(jwt.Parser).ParseUnverified(validToken, jwt.MapClaims{})
    if err != nil {
        fmt.Println(err)
        return
    }
    fmt.Println(token)
}
// {/fact}

// {fact rule=protection-mechanism-failure@v1.0 defects=0}
func jwtGoParseUnverifiedCompliant() {
    validToken := "valid.token.string"
    keyFunc := func(token *jwt.Token) (interface{}, error){
        return []byte("your-secret-key"), nil
    }
    // Compliant: `ParseWithClaims` used in here.
    token, err := new(jwt.Parser).ParseWithClaims(validToken, jwt.MapClaims{}, keyFunc)
    if err != nil {
        fmt.Println(err)
        return
    }
    fmt.Println(token)
}
// {/fact}