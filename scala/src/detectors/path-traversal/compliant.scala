/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

class PathTraversalCompliant {
  @throws[FileUploadException]
    // {fact rule=path-traversal@v1.0 defects=0}
    def compliant(req: HttpServletRequest): Unit = {
        val upload = new ServletFileUpload(new DiskFileItemFactory())
        val fileItems = upload.parseRequest(req)
        for (item <- fileItems.asScala) {
            val filename = FilenameUtils.getName(item.getName()) // Get only the filename without the path
            // Compliant: The code uses `FilenameUtils.getName()` to extract the filename, which mitigates the risk of path traversal vulnerabilities by removing the path from the filename.
            println("Saving " + filename + "...")
            // Process the file using the sanitized filename
        }
    }
    // {/fact}
}