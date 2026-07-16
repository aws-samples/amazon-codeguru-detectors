/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=deadlock-and-lock-inconsistency@v1.0 defects=0}
 use std::sync::{Arc, Mutex,RwLock};
 use std::sync::atomic::{AtomicUsize, Ordering};
 use std::thread;

    fn compliant() {
    // Compliant: using `std::sync` module types `Mutex `, `RwLock`
	     let data = Arc::new(Mutex::new(0));
	     let t1 = {
	         let data = Arc::clone(&data);
	         thread::spawn(move || {
	             let mut data = data.lock().unwrap();
	             for _ in 0..1_000_000 {
	                 *data += 1;
	             }
	         })
	     };

	     let t2 = {
	         let data = Arc::clone(&data);
	         thread::spawn(move || {
	             let mut data = data.lock().unwrap();
	             for _ in 0..1_000_000 {
	                 *data -= 1;
	             }
	         })
	     };
	     t1.join().unwrap();
	     t2.join().unwrap();

	     println!("Final data value: {:?}", data.lock().unwrap());
	}
// {/fact}