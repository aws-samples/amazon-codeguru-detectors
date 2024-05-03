using Newtonsoft.Json;

namespace InsecureDeserialization
{
    class UntrustedDeserialization
    {
        // {fact rule=untrusted-deserialization@v1.0 defects=1}
        public void UntrustedDeserializationNoncompliant(String jsonpath)
        {
            JsonConvert.DeserializeObject<object>(jsonpath, new JsonSerializerSettings
                {
                    // Noncompliant: `TypeNameHandling.All` is not safe.
                    TypeNameHandling = TypeNameHandling.All
                }
            );
        }
        // {/fact}
        
        // {fact rule=untrusted-deserialization@v1.0 defects=0}
        public void UntrustedDeserializationCompliant(String jsonpath)
        {
            JsonConvert.DeserializeObject<object>(jsonpath, new JsonSerializerSettings
            {
                // Compliant: `TypeNameHandling.None` is safe.
                TypeNameHandling = TypeNameHandling.None
                }
            );
        }
        // {/fact}
    }
}