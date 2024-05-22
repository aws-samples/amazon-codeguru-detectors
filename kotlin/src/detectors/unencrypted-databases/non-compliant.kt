/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=missing-encryption-of-sensitive-data@v1.0 defects=1}
// Noncompliant: The lack of proper data encryption
fun noncompliant() {
val config = RealmConfiguration.Builder().build()
     val realm = Realm.getInstance(config) 
}
// {/fact}
