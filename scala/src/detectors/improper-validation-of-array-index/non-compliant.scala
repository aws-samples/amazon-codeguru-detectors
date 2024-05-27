/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

class ImproperValidationOfArrayIndexNoncompliant {
    // {fact rule=improper-validation-of-array-index@v1.0 defects=1}
    def nonCompliant(){
        val color = "blue"
        val strings = List("blue", "bob")
        // Noncompliant: This overlooks the first element.
        if(strings.indexOf(color) > 0){
            println("Color not found");
        }
    }
    // {/fact}
}