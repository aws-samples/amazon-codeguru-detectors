
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=server-side-request-forgery@v1.0 defect=1}
function nonCompliant(){
    //NonCompliant: Does not ensures the request is being sent to the expected destination
    $file = file_get_contents($_POST['r']);
}
//{/fact}