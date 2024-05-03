namespace ThreadSafe
{
    class ThreadSafetyViolation
    {
        int result = 0;
        private readonly object mainLock = new object();
        
        // {fact rule=thread-safety-violation@v1.0 defects=1}
        public void ThreadSafetyViolationNoncompliant()
        {
            for (int i = 0; i < 100000; i++)
            {
                // Noncompliant: This global variable is accessed without a lock.
                result = result + 1;
            }
        }
        // {/fact}
        
        // {fact rule=thread-safety-violation@v1.0 defects=0}
        public void ThreadSafetyViolationCompliant()
        {
            for (int i = 0; i < 100000; i++)
            {
                // Compliant: Provide lock to protect the integrity of the global variable.
                Monitor.Enter(mainLock);
                result = result + 1;
                Monitor.Exit(mainLock);
            }
        }
        // {/fact}
    }
}

