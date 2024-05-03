namespace FileUpload
{
    class UnrestrictedFileUpload
    {
        private string uploadedFile;
        private string fileContent;
        private string safeUploadFolder = @"C:\temp\secure";
        
        // {fact rule=unrestricted-file-upload@v1.0 defects=1}
        public void UnrestrictedFileUploadNoncompliant()
        {
            try {
                // Noncompliant: the filename is user controlled.
                string completePathNewFile= safeUploadFolder + System.IO.Path.PathSeparator + uploadedFile;
                if (!File.Exists(completePathNewFile))
                {
                    using (StreamWriter sw = File.CreateText(completePathNewFile))
                    {
                        sw.WriteLine(fileContent);
                    }
                }
                Console.WriteLine("SUCCESS");
            } catch (System.Exception e) {
                Console.WriteLine("ERROR");
            }
        }
        // {/fact}
        
        // {fact rule=unrestricted-file-upload@v1.0 defects=0}
        public void UnrestrictedFileUploadCompliant()
        {
            try {
                // Compliant: Restrict the upload path, and ensure it is outside of the webroot.
                string fileNameSanitized = System.IO.Path.GetFileName(uploadedFile);
                string completePathNewFile= safeUploadFolder + System.IO.Path.PathSeparator + fileNameSanitized;
                if (!File.Exists(completePathNewFile))
                {
                    using (StreamWriter sw = File.CreateText(completePathNewFile))
                    {
                        sw.WriteLine(fileContent);
                    }
                }
                Console.WriteLine("SUCCESS");
            } catch (System.Exception e) {
                Console.WriteLine("ERROR");
            }
        }
        // {/fact}
    }
}

