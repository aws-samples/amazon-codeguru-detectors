/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


use reqwest::header;
use reqwest::{blocking::Client, header::HeaderMap, header::HeaderValue, Url};
// {fact rule=set-sensitive@v1.0 defects=0}
// Compliant: set sensitive set to true
   let mut headers = header::HeaderMap::new();
   let header = header::HeaderValue::from_static("secret");
   header.set_sensitive(true);
   headers.insert(header::AUTHORIZATION, header);
// {/fact}