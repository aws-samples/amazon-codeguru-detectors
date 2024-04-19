
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=incorrect-comparison@v1.0 defects=0}
// Compliant: used type-safe comparison (`===`)
md5("240610708") === "0";
//{/fact}