<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=untrusted-deserialization@v1.0 defects=0}
// Compliant: EXTR_SKIP is used to skip the extraction of the variable.
$ok = $_FILES["/some/bad/path"];
extract($ok, EXTR_SKIP, "wddx");
//{/fact}     
?>