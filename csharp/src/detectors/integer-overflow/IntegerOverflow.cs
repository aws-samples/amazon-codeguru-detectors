namespace OverFlow
{
    class IntegerOverflow
    {
        // {fact rule=integer-overflow@v1.0 defects=1}
        public void IntegerOverflowNoncompliant()
        {
            long data;
            data = long.MaxValue;
            // Noncompliant: if `data == long.MaxValue` then this will overflow.
            long result = (long)(data + 1);
            Console.WriteLine("result: " + result);
        }
        // {/fact}
        
        // {fact rule=integer-overflow@v1.0 defects=0}
        public void IntegerOverflowCompliant()
        {
            long data;
            // Compliant: Use a hardcoded number that won't cause overflow.
            data = 2;
            long result = (long)(data + 1);
            Console.WriteLine("result: " + result);
        }
        // {/fact}
    }
}

