package main

import (
	"database/sql"
	"net/http"
)

// {fact rule=sql-injection@v1.0 defects=1}
func concatenationSqlInjectionNoncompliant(database *sql.DB, request *http.Request) {
	// Noncompliant: direct user input is used
	database.Exec("SELECT * FROM Users WHERE City=" + request.FormValue("city"))
}
// {/fact}

// {fact rule=sql-injection@v1.0 defects=0}
func concatenationSqlInjectionCompliant(database *sql.DB) {
	// Compliant: direct user input is not used
	database.Exec("SELECT * FROM Users WHERE City=" + "Berlin")
}
// {/fact}
