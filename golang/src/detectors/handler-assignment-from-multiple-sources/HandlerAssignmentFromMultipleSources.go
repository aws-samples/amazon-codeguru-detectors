package main

import (
	"net/http"

	"github.com/gorilla/sessions"
)

type User struct {
	userId    string
	accountId string
}

func ValidateUser(userId string) bool {
	return true
}

func RetrieveUser(userId string) User {
	return User{userId, "0000"}
}

var store = sessions.NewCookieStore([]byte("blah-blah-blah"))

// {fact rule=authentication-bypass-by-alternate-name@v1.0 defects=1}
func handlerAssignmentFromMultipleSourcesNoncompliant(w http.ResponseWriter, r *http.Request) {
	session, _ := store.Get(r, "blah-session")
	userId := session.Values["user_id"].(string)

	if !ValidateUser(userId) {
		http.Error(w, "Error", http.StatusInternalServerError)
		return
	}
	// Noncompliant: var `user_id` assigned from multiple sources
	userId = r.URL.Query().Get("user_id")

	userObj := RetrieveUser(userId)
	userObj.accountId = r.URL.Query().Get("account_id")
}

// {/fact}

// {fact rule=authentication-bypass-by-alternate-name@v1.0 defects=0}
func handlerAssignmentFromMultipleSourcesCompliant(w http.ResponseWriter, r *http.Request) {
	// Compliant: var `user_id` assigned from one source
	userId := r.URL.Query().Get("user_id")

	if !ValidateUser(userId) {
		http.Error(w, "Error", http.StatusInternalServerError)
		return
	}

	userObj := RetrieveUser(userId)
	userObj.accountId = r.URL.Query().Get("account_id")
}

// {/fact}
