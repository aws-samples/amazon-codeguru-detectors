
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=weak-random-number-generation@v1.0 defects=1}
// Noncompliant: Insecure way of generating random number
$insecurerandomNumber = mt_rand();
//{/fact}
