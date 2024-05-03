package main

import (
	"sync"
)

// {fact rule=thread-safety-violation@v1.0 defects=1}
func threadSafetyViolationNoncompliant(){
    var counter int
    var wg sync.WaitGroup

    for i:=0; i < 1000; i++{
        wg.Add(1)
        go func() {
            // Noncompliant: incrementing without synchronization.
            counter ++
            wg.Done()
        }()
    }
    wg.Wait()
}
// {/fact}

// {fact rule=thread-safety-violation@v1.0 defects=0}
func threadSafetyViolationCompliant(){
    var counter int
    var wg sync.WaitGroup
    var mu sync.Mutex
    for i:=0; i < 1000; i++{
        wg.Add(1)
        go func() {
            mu.Lock()
            // Compliant: `sync.Mutex` is used to ensure only one goroutine can modify shared data at a time.
            counter ++
            mu.Unlock()
            wg.Done()
        }()
    }
    wg.Wait()
}
// {/fact}
