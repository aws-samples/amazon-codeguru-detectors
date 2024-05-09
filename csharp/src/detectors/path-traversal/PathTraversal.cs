namespace Traversal
{
    class PathTraversal
    {
        // {fact rule=path-traversal@v1.0 defects=1}
        public static byte[] PathTraversalNoncompliant(string filename)
        {
            if (string.IsNullOrEmpty(filename)) 
            {   
                throw new ArgumentNullException("error"); 
            }
            string filepath = Path.Combine("/pathToMyImage/images/", filename); 
            // Noncompliant: Reading data from a file without sanitization.
            return File.ReadAllBytes(filepath);
        }
        // {/fact}
        
        // {fact rule=path-traversal@v1.0 defects=0}
        public static byte[] PathTraversalCompliant(string filename)
        {
            if (string.IsNullOrEmpty(filename)) 
            {   
                throw new ArgumentNullException("error"); 
            }
            filename = Path.GetFileName(filename);
            // Compliant: `Path.GetFileName` used for sanitization.
            string filepath = Path.Combine("/pathToMyImage/images/", filename); 
            return File.ReadAllBytes(filepath);
        }
        // {/fact}
    }
}

