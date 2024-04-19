
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=weak-random-number-generation@v1.0 defects=0}
// Compliant: Securly generate random number
$secureRandomNumber = random_bytes(16);
//{/fact}
?>
