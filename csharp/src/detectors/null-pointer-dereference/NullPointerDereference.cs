namespace NullPointer
{
    class NullPointerDereference
    {
        private int privateFive = 5;
        // {fact rule=null-pointer-dereference@v1.0 defects=1}
        public void NullPointerDereferenceNoncompliant()
        {
            if (privateFive == 5)
            {
                {
                    string myString = null;
                    // Noncompliant: Using a single `&` in the if statement will cause both sides of the expression to be evaluated.
                    if ((myString != null) & (myString.Length > 0))
                    {
                        Console.WriteLine("The string length is greater than 0");
                    }
                }
            }
        }
        // {/fact}
        
        // {fact rule=null-pointer-dereference@v1.0 defects=0}
        public void NullPointerDereferenceCompliant()
        {
            if (privateFive == 5)
            {
                {
                    string myString = null;
                    // Compliant: Use `&&` in the if statement so that if the left side of the expression fails then the right side will not be evaluated.
                    if ((myString != null) && (myString.Length > 0))
                    {
                        Console.WriteLine("The string length is greater than 0");
                    }
                }
            }
        }
        // {/fact}
    }
}

