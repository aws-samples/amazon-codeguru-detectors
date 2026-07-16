using System;
	 
	 public class Example
	 {

        // {fact rule=double-epsilon-equality@v1.0 defects=1}
	    static bool lazyEqualLeftCompare(double v1, double v2){
	        // Noncompliant: valur other than 0
	        return Math.Abs(v1 - v2) <= Double.Epsilon;
	    }
        // {/fact}

        // {fact rule=double-epsilon-equality@v1.0 defects=0}
	 
	    static bool uselessZeroEqual(){
	        double v1 = 0;
	        double v2 = 0;
	        // Compliant: value is zero
	        return Math.Abs(v1 - v2) <= Double.Epsilon;
	    }
        // {/fact}
     }