namespace Validation
{
    class MethodInputValidation
    {
        // {fact rule=method-input-validation@v1.0 defects=1}
        [HttpPost]
        [ValidateAntiForgeryToken]
        // Noncompliant: Disabling input validation for the method.
        [ValidateInput(false)]
        public ActionResult MethodInputValidationNoncompliant(string input) {
            return null;
        }
        // {/fact}

        // {fact rule=method-input-validation@v1.0 defects=0}
        [HttpPost]
        [ValidateAntiForgeryToken]
        // Compliant: Enabling input validation for the method.
        [ValidateInput(true)]
        public ActionResult MethodInputValidationCompliant(string input) {
            return null;
        }
        // {/fact}
    }
}

