/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=missing-encryption-of-sensitive-data@v1.0 defects=0}
// Compliant: Proper data encryption
fun compliant() {
    val config = RealmConfiguration.Builder()
    .encryptionKey(getKey())
    .build()
     val realm = Realm.getInstance(config)
}
// {/fact}
