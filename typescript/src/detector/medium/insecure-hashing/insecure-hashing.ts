// {fact rule=insecure-hashing@v1.0 defects=1}
import crypto from 'crypto'
function insecureHashingNoncompliant() {
  // Noncompliant: 'md5' is weak hash algorithm.
  var insecure_hash_algo = 'md5'
  crypto.createHash(insecure_hash_algo)
}
// {/fact}

// {fact rule=insecure-hashing@v1.0 defects=0}
import crypto from 'crypto'
function insecureHashingCompliant() {
  // Compliant: 'SHA-256' is secure hash algorithm.
  var secure_hash_algo = 'SHA-256'
  crypto.createHash(secure_hash_algo)
}
// {/fact}
