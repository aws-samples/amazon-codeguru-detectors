<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=sensitive-information-leak@v1.0 defects=0}
// Compliant: fsockopen() is used to connect to a remote host.
$abc->fsockopen($hostname); 
// {/fact}
?>