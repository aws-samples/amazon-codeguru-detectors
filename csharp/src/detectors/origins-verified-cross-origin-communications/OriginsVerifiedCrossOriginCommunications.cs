using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;

namespace CrossOrigin
{
    class OriginsVerifiedCrossOriginCommunications
    {
        // {fact rule=origins-verified-cross-origin-communications@v1.0 defects=1}
        public void ConfigureNoncompliant(IServiceCollection service)
        {
            // Noncompliant: The HSTS HTTP response security header is missing.
            service.AddControllers();
        }
        // {/fact}
        
        // {fact rule=origins-verified-cross-origin-communications@v1.0 defects=0}
        public void ConfigureCompliant(IServiceCollection service)
        {
            service.AddControllers();
            // Compliant: `AddHsts` HTTP response security header is used.
            service.AddHsts(options =>
            {
                options.Preload = true;
                options.IncludeSubDomains = true;
                options.MaxAge = TimeSpan.FromDays(365);
            });
        }
        // {/fact}
    }
}

