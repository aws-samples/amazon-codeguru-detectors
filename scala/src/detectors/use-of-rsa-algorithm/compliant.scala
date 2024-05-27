/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.crypto.Cipher

// {fact rule=use-of-rsa-algorithm@v1.0 defects=0}
object UseOfRSAAlgorithmCompliant {
  def compliant(args: Array[String]): Unit = {
    // Compliant: Encrypt with RSA using OAEP padding.
    val cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding")
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    val ciphertext = cipher.doFinal(plaintext.getBytes("UTF-8"))
    println("Encrypted: " + javax.xml.bind.DatatypeConverter.printHexBinary(ciphertext))
  }
}
// {/fact}