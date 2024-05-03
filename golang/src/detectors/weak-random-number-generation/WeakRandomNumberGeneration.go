package main

import (
	crand "crypto/rand"
	"math/big"
	mrand "math/rand"
	"time"
)

var charset = []byte("abcdeABCDE0123456789")

// {fact rule=weak-random-number-generation@v1.0 defects=1}
func weakRandomNumberGenerationNoncompliant(length int) string {
	r := mrand.New(mrand.NewSource(time.Now().UnixNano()))
    result := make([]byte, length)
    for i := range result {
        // Noncompliant: `math.rand` is used for generating random number.
        result[i] = charset[r.Intn(len(charset))]
    }
    return string(result)
}
// {/fact}

// {fact rule=weak-random-number-generation@v1.0 defects=0}
func weakRandomNumberGenerationCompliant(length int) string  {
	result := make([]byte, length)
	max := big.NewInt(int64(len(charset)))
	for i := range result {
		// Noncompliant: `math.rand` is used for generating random number.
		n, _ := crand.Int(crand.Reader, max)
		result[i] = charset[n.Int64()]
	}
	return string(result)
}
// {/fact}
