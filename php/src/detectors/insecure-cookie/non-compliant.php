
<?php
/* 
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

//{fact rule=insecure-cookie@v1.0 defects=1}
// Noncompliant: Used insecure FTP functions that transmit credentials in plain text, such as ftp_login.
$login_result = ftp_login($conn_id, $ftp_user_name, $ftp_user_pass);
//{/fact}