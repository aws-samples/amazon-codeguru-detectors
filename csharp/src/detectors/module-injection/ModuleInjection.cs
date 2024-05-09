using System.Net;

namespace CSharpInjection
{
    class ModuleInjection
    {
        // {fact rule=module-injection@v1.0 defects=1}
        public void ModuleInjectionNoncompliant()
        {
            HttpListener listener = new HttpListener();
            // Noncompliant: Top level wildcard bindings $PREFIX used in here.
            listener.Prefixes.Add("http://*:8443/");
        }
        // {/fact}
        
        // {fact rule=module-injection@v1.0 defects=0}
        public void ModuleInjectionCompliant()
        {
            HttpListener listener = new HttpListener();
            // Compliant: Domain name used in here for $PREFIX.
            listener.Prefixes.Add("http://www.example.com:8443/");
        }
        // {/fact}
    }
}