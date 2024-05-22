/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=missing-encryption-of-sensitive-data@v1.0 defects=0}
// Compliant: File has been encrypted
fun compliant(password: String): String {
    val mainKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    val encryptedFile = EncryptedFile.Builder(
        File(activity.filesDir, "data.txt"),
        activity,
        mainKey,
        EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
    ).build()

    encryptedFile.openFileOutput().apply {
        write(fileContent)
        flush()
        close()
    }
}
// {/fact}
