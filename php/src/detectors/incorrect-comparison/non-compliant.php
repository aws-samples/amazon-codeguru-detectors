/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=incorrect-comparison@v1.0 defect=1}
md5("240610708") == "0";
//{/fact}