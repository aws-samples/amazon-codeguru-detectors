/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=thread-safety-violation@v1.0 defects=0}
// Compliant: Using synchronous contexts `tokio::fs` and `tokio::net`

use tokio::fs;
use tokio::task;

async fn write_file_blocking(file_path: &str, content: &str) -> Result<(), std::io::Error> {
    task::spawn_blocking(move || {
        fs::write(file_path, content)
    })
    .await
    .unwrap()?;

    Ok(())
}
// {/fact}