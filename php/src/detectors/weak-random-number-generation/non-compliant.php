/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

<?php

//{fact rule=weak-random-number-generation@v1.0 defect=1}
$insecurerandomNumber = mt_rand();
//{/fact}
