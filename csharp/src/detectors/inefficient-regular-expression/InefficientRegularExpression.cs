using System.Text.RegularExpressions;

namespace RegularExpression
{
    class InefficientRegularExpression
    {
        // {fact rule=regular-expression-dos@v1.0 defects=1}
        public void InefficientRegularExpressionNoncompliant(String str)
        {
            // Noncompliant: Timeout interval is not set here.
            Regex regex = new Regex("^M(N|C+)+D");
            regex.Match(str);
        }
        // {/fact}
        
        // {fact rule=regular-expression-dos@v1.0 defects=0}
        public void InefficientRegularExpressionCompliant(String str)
        {
            // Compliant: Timeout interval is set for regex creation.
            Regex regex = new Regex("^M(N|C+)+D", new RegexOptions { }, TimeSpan.FromSeconds(2));
            regex.Match(str);
        }
        // {/fact}
    }
}