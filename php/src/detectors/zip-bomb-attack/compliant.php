<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

 //{fact rule=zip-bomb-attack@v1.0 defects=0}
 // Compliant: `zip_entry_read` will read the next 1024 bytes of data from the zip entry starting from the current position.
 zip_entry_read($zip_entry, 1024); 
// {/fact}
?>