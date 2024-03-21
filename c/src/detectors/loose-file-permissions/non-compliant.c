/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=loose-file-permissions@v1.0 defects=1}
#include <sys/stat.h>
#include <fcntl.h>

void looseFilePermissionsNonCompliant(){

  int fd;

  // Noncompliant: The process set 777 permissions to this newly created file
  open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG | S_IRWXO); 

  // Noncompliant: The process try to set 777 permissions to this newly created directory
  mkdir("myfolder", S_IRWXU | S_IRWXG | S_IRWXO);  
  
  // Noncompliant: The process set 777 permissions to this file
  chmod("myfile.txt", S_IRWXU | S_IRWXG | S_IRWXO);  
}
// {/fact}