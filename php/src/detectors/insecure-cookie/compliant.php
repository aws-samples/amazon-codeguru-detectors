
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=insecure-cookie@v1.0 defects=0}
// Compliant: Used secure file transfer functions like ssh2_scp_send
ssh2_scp_send($connection, '/local/filename', '/remote/filename', 0644);
//{/fact}