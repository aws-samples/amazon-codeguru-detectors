/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=null-pointer-dereference@v1.0 defects=1}
// Noncompliant: Dereferencing freed pointer
fun noncompliant() {
    val byteBuffer = ByteBuffer.allocateDirect(Int.SIZE_BYTES)
    val ptr = byteBuffer.asIntBuffer()
    byteBuffer.clear()
    val value = ptr[0] 
}
// {/fact}
