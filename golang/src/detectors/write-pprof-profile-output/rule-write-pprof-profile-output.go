package main

import(
    "net/http"
    "runtime/pprof"
	"os"
)

// {fact rule=best-practices@v1.0 defects=1}
func dumpGoroutines1(w http.ResponseWriter, r *http.Request, t auth.Token) error {
    if !permission.Check(t, permission.PermDebug) {
        return permission.ErrUnauthorized
    }

    // Noncompliant:  pprof profile is not removed
    return pprof.Lookup("goroutine").WriteTo(w, 2)
}
//{fact}

// {fact rule=write-pprof-profile-output@v1.0 defects=0}
func dumpGoroutines2(w http.ResponseWriter, r *http.Request, t auth.Token) error {
    if !permission.Check(t, permission.PermDebug) {
        return permission.ErrUnauthorized
    }

    // Compliant:  pprof profile is removed
    return pprof.Lookup("goroutine").WriteTo(os.Stdout, 0)
}
//{fact}