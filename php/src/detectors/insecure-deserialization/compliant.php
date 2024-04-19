
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=object-input-stream-insecure-deserialization@v1.0 defects=0}
// Compliant: Only unserialize trusted and validated data to prevent potential security risks
$object2 = unserialize('O:1:"a":1:{s:5:"value";s:3:"100";}');
//{/fact}

