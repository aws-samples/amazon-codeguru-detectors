/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=untrusted-data-in-decision@v1.0 defects=0}
// Compliant: secured hasing algorithm `Sha256` used
   use clap::App;
   let matches = App::new("MyApp");
// {/fact}