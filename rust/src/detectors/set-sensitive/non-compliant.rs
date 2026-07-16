/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=set-sensitive@v1.0 defects=1}
use reqwest::header;
use reqwest::{blocking::Client, header::HeaderMap, header::HeaderValue, Url};
// Noncompliant: set sensitive not been set to true
	 let mut headers = header::HeaderMap::new();
	 let header = header::HeaderValue::from_static("secret");
	 headers.insert(header::AUTHORIZATION, header);
// {/fact}