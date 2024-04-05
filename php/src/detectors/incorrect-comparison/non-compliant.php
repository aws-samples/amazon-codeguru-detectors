
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=incorrect-comparison@v1.0 defect=1}
//NonCompliant: Used loose equality (`==`)
md5("240610708") == "0";
//{/fact}