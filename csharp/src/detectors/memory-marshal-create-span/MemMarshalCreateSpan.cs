namespace MemMarshalCreateSpan {
	     public class MemMarshalCreateSpan {
             // {fact rule=memory-marshal-create-span@v1.0 defects=1}
	         public void MarshalNoncompliant() {
        
	             // Noncompliant: length argument is not checked
	             Span<T> ToSpan() => MemoryMarshal.CreateSpan(ref _e0, 1);
	 
	         }
             // {/fact}

            // {fact rule=memory-marshal-create-span@v1.0 defects=0}
             public void MarshalCompliant() {
                memory-marshal-create-span@v1.0
	 
	             // Compliant: length argument is checked
	             Span<int> intSpan = MemoryMarshal.Cast<byte, int>(byteSpan);
	 
	         }
             // {/fact}
	     }
	 }