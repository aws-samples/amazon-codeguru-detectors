<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=untrusted-deserialization@v1.0 defects=1}
    $bad2 = $_FILES["/some/bad/path"];
	// Noncompliant: EXTR_PREFIX_SAME is used to extract variables with the same name.
	 extract($bad2, EXTR_PREFIX_SAME, "wddx");
//{/fact} 
?>