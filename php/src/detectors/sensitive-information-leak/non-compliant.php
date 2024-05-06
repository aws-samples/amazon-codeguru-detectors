<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=isensitive-information-leak@v1.0 defects=1}
// Noncomplaint: socket_create() is considered for connection
socket_create($domain, $type, $protocol); 
// {/fact}
?>