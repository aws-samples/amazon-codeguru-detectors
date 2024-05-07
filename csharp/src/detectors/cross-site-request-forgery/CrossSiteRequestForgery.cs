using Microsoft.AspNetCore.Mvc;

namespace CSRF
{
    class CrossSiteRequestForgery
    {
        // {fact rule=cross-site-request-forgery@v1.0 defects=1}
        [HttpPost]
        // Noncompliant: Does not enforce anti-forgery token validation.
        public ActionResult CrossSiteRequestForgeryNoncompliant(User user) {
          CreateUser(user);
        }
        // {/fact}

        // {fact rule=cross-site-request-forgery@v1.0 defects=0}
        [HttpPost]
        // Compliant: Enforce anti-forgery token validation.
        [ValidateAntiForgeryToken]
        public IActionResult CrossSiteRequestForgeryNoncompliant(User user){
          CreateUser(user);
        }
        // {/fact}
    }
}

