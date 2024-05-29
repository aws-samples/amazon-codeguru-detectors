/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=deadlock-and-lock-inconsistency@v1.0 defects=1}

use std::sync::atomic::{AtomicUsize, Ordering};
use std::sync::{Arc, Mutex,RwLock};
use std::thread;

static COUNTER: AtomicUsize = AtomicUsize::new(0);
    fn noncompliant() {
	     let mut data = 0;
    // Noncompliant: Not using sync module types `Mutex `, `RwLock`
	     let t1 = thread::spawn(move || {
	         for _ in 0..1_000_000 {
	             data += 1;
	         }
	     });

	     let t2 = thread::spawn(move || {
	         for _ in 0..1_000_000 {
	             data -= 1;
	         }
	     });

	     t1.join().unwrap();
	     t2.join().unwrap();

	     println!("Final data value: {}", data);
	}
// {/fact}