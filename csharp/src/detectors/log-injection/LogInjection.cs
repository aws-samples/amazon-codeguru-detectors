using Serilog;

namespace CSharpInjection
{
    class LogInjection
    {
        // {fact rule=log-injection@v1.0 defects=1}
        public void LogInjectionNoncompliant()
        {
            using var log = new LoggerConfiguration().WriteTo.Console().CreateLogger();

            var pos = new { Latitude = 25, Longitude = 134 };
            var elMs = 34;

            // Noncompliant: String interpolation in log message.
            log.Information($"Processed {pos} in {elMs:000} ms.");
        }
        // {/fact}
        
        // {fact rule=log-injection@v1.0 defects=0}
        public void LogInjectionCompliant()
        {
            using var log = new LoggerConfiguration().WriteTo.Console().CreateLogger();

            var pos = new { Latitude = 25, Longitude = 134 };
            var elMs = 34;

            // Compliant: Use structured logging.
            log.Information("Processed {@Position} in {Elapsed:000} ms.", pos, elMs);
        }
        // {/fact}
    }
}

