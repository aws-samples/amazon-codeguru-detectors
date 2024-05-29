/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-error-handling@v1.0 defects=0}
// Compliant: `?` operator enables more structured and graceful error handling
    let mut f = std::fs::File::open(filename)?;
	let mut buf = Vec::new();
// {/fact}