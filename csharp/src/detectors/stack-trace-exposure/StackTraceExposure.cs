using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.Hosting;

namespace StackTrace
{
    class StackTraceExposure
    {
        // {fact rule=stack-trace-exposure@v1.0 defects=1}
        public void StackTraceExposureNoncompliant(IApplicationBuilder application, IHostEnvironment environment)
        {
            if (!environment.IsDevelopment())
            {
                // Noncompliant: Stacktrace information is displayed in a non-Development environment.
                application.UseDeveloperExceptionPage();
            }
            else
            {
                application.UseExceptionHandler("/Error");
            }
        }
        // {/fact}
        
        // {fact rule=stack-trace-exposure@v1.0 defects=0}
        public void StackTraceExposureCompliant(IApplicationBuilder application, IHostEnvironment environment)
        {
            if (environment.IsDevelopment())
            {
                // Compliant: Stacktrace information is displayed in a Development environment.
                application.UseDeveloperExceptionPage();
            }
            else
            {
                application.UseExceptionHandler("/Error");
            }
        }
        // {/fact}
    }
}

