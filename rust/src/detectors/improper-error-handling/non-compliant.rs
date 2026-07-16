/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-error-handling@v1.0 defects=1}
// Noncompliant: Usage of `unwrap()` to handle the result of `File::open()`
    let mut f = std::fs::File::open("../monsterdata_test.mon").unwrap();
	let mut buf = Vec::new();
// {/fact}