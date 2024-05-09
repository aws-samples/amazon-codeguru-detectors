using System.Diagnostics;

namespace CSharpInjection
{
    class OsCommandInjection
    {
        // {fact rule=os-command-injection@v1.0 defects=1}
        public void OsCommandInjectionNoncompliant(String path)
        {
            // Noncompliant: user-supplied parameter is passed to `Process.Start()`.
            Process.Start(path);
        }
        // {/fact}
        
        // {fact rule=os-command-injection@v1.0 defects=0}
        public void OsCommandInjectionCompliant(String path)
        {
            // Compliant: string is passed to `Process.Start()`.
            Process.Start("path");
        }
        // {/fact}
    }
}
