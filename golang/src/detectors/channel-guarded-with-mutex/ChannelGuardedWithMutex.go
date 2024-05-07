package main

import (
	"fmt"
	"sync"
)

// {fact rule=channel-guarded-with-mutex@v1.0 defects=1}
func channelGuardedWithMutexNoncompliant() {
	var mutex = &sync.Mutex{}
	msg := make(chan string)

	go func() {
		msg <- "ping"
	}()

	// Noncompliant: Channel guarded with mutex.
	mutex.Lock()
	message := <-msg
	mutex.Unlock()
	fmt.Println(message)
}

// {/fact}

// {fact rule=channel-guarded-with-mutex@v1.0 defects=0}
func channelGuardedWithMutexCompliant() {
	msg := make(chan string)

	go func() {
		msg <- "ping"
	}()

	// Compliant: Channel is not guarded with mutex.
	message := <-msg
	fmt.Println(message)
}

// {/fact}
