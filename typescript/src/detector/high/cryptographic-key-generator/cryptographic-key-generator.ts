import * as crypto from 'crypto'
// {fact rule=cryptographic-key-generator@v1.0 defects=1}
function cryptographicKeyGeneratorNoncompliant()
{
  var object = {
    // Noncompliant: 'modulusLength' is less than 2048 bits.
    modulusLength: 1024,
    publicKeyEncoding: {
      type: 'spki',
      format: 'pem'
    },
    privateKeyEncoding: {
      type: 'pkcs8',
      format: 'pem',
      cipher: 'aes-256-cbc',
      passphrase: 'top secret'
    }
  }
  var { publicKey, privateKey} = crypto.generateKeyPairSync('rsa',object)
}
// {/fact}

import * as crypto from 'crypto'
// {fact rule=cryptographic-key-generator@v1.0 defects=0}
function cryptographicKeyGeneratorCompliant()
{
  var object = {
    // Compliant: 'modulusLength' is 2048 bits.
    modulusLength: 2048,
    publicKeyEncoding: {
      type: 'spki',
      format: 'pem'
    },
    privateKeyEncoding: {
      type: 'pkcs8',
      format: 'pem',
      cipher: 'aes-256-cbc',
      passphrase: 'top secret'
    }
  }
  var { publicKey, privateKey} = crypto.generateKeyPairSync('rsa', object)
}
// {/fact}