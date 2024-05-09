using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;


namespace Auth
{
    internal class AuthorizeAttribute : Attribute
    {
        public string Roles { get; set; }
    }
    
    // {fact rule=missing-authorization@v1.0 defects=1}
    
    // Noncompliant: Access control checks are missing.
    [AllowAnonymous]
    public class AtLeast21Controller : Controller
    {
        public IActionResult Index() => View();

        private IActionResult View()
        {
            throw new NotImplementedException();
        }

        public interface IActionResult
        {
        }
    }
    // {/fact}
    
    
    // {fact rule=missing-authorization@v1.0 defects=0}
    
    // Compliant: Access only permitted for specific role.
    [Authorize(Roles = "LegalAdultGroup")]
    public class AtLeast21Controller2 : Controller
    {
        public IActionResult Index() => View();

        private IActionResult View()
        {
            throw new NotImplementedException();
        }
    }
    // {/fact}
}

