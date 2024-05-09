<?php

/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

 //{fact rule=zip-bomb-attack@v1.0 defects=1}
 // Noncompliant: The entire content of the zip entry is read and returned by `zip_entry_read`
 zip_entry_read($zip_entry, zip_entry_filesize($zip_entry)); 
// {/fact}
?>