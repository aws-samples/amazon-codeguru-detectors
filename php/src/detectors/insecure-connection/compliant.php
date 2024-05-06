<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-connection@v1.0 defects=0}
 // Compliant: CURLOPT_SSL_VERIFYPEER is set to true
 curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, true);
 // {/fact}

?>