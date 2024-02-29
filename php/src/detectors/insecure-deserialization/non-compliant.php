/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=object-input-stream-insecure-deserialization@v1.0 defect=1}
$data = $_GET["data"];
$object = unserialize($data);
//{/fact}
