<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-connection@v1.0 defects=1}
// Noncompliant: CURLOPT_SSL_VERIFYPEER is set to false
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
// {/fact}

?>