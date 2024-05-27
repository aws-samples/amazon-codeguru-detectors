/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

class ImproperValidationOfArrayIndexCompliant {
    // {fact rule=improper-validation-of-array-index@v1.0 defects=0}
    def compliant(){
        val color = "blue"
        val strings = List("blue", "bob")
        // Compliant: This does not overlook the first element.
        if(strings.indexOf(color) >= 0){
            println("Color not found");
        }
    }
    // {/fact}
}