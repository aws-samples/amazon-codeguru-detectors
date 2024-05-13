package main

import(
    "net/http"
    "runtime/pprof"
	"os"
)

func dumpGoroutines1(w http.ResponseWriter, r *http.Request, t auth.Token) error {
    if !permission.Check(t, permission.PermDebug) {
        return permission.ErrUnauthorized
    }

    // ruleid: rule-write-pprof-profile-output
    return pprof.Lookup("goroutine").WriteTo(w, 2)
}

func dumpGoroutines2(w http.ResponseWriter, r *http.Request, t auth.Token) error {
    if !permission.Check(t, permission.PermDebug) {
        return permission.ErrUnauthorized
    }

    // ruleid: rule-write-pprof-profile-output
    return pprof.Lookup("goroutine").WriteTo(os.Stdout, 2)
}
func dumpGoroutines3(w http.ResponseWriter, r *http.Request, t auth.Token) error {
    if !permission.Check(t, permission.PermDebug) {
        return permission.ErrUnauthorized
    }

    // ok: rule-write-pprof-profile-output
    return pprof.Lookup("goroutine").WriteTo(r, 0)
}