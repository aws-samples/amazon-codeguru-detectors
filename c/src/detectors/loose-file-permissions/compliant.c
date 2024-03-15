/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=loose-file-permissions@v1.0 defects=0}
#include <sys/stat.h>
#include <fcntl.h>

void looseFilePermissionsCompliant(){
  
  int fd;

  // Compliant: The O_CREAT flag indicates that the file should be created if it doesn't exist.
  open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG); 
  // Compliant: further created files or directories will not have permissions set for "other group"
  umask(S_IRWXO); 
  
}
// {/fact}