using System;
	 using System.Globalization;
	 
	 public class SamplesRegionInfo  {
	 
	    public static void Main()  {
	 
	       RegionInfo myRI1 = new RegionInfo( "US" );

	       RegionInfo myRI2 = new RegionInfo( new CultureInfo("en-US",false).LCID );

        // {fact rule=regioninfointerprocesswrite@v1.0 defects=1}
	       using (AnonymousPipeServerStream pipeServer =
	                   new AnonymousPipeServerStream(PipeDirection.Out,
	                   HandleInheritability.Inheritable)){
	       using(StreamWriter sw = new StreamWriter(pipeServer)){
	          // Noncompliant: two-letter culture name
	          sw.WriteLine(myRI1);
	       }}
        // {/fact}

        // {fact rule=regioninfointerprocesswrite@v1.0 defects=0}
           using (AnonymousPipeServerStream pipeServer =
	                   new AnonymousPipeServerStream(PipeDirection.Out,
	                   HandleInheritability.Inheritable)){
	       using(StreamWriter sw = new StreamWriter(pipeServer)){
	          // Compliant: full culture name used
	          sw.WriteLine(myRI2);
	       }}
           // {/fact}
	    }
	 }

