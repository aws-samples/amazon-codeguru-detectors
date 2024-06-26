/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=null-pointer-dereference@v1.0 defects=0}
// Compliant: Added a null check before dereferencing the pointer.
fun compliant() {
    val byteBuffer = ByteBuffer.allocateDirect(Int.SIZE_BYTES)
    val ptr = byteBuffer.asIntBuffer()
    if(ptr != null) {
        val value = ptr[0] 
        byteBuffer.clear()
    }
}
// {/fact}
