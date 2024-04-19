
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=object-input-stream-insecure-deserialization@v1.0 defects=1}
// Noncompliant: User input ($_GET["data"]) as it can lead to insecure deserialization vulnerabilities.
$data = $_GET["data"];
$object = unserialize($data);
//{/fact}
