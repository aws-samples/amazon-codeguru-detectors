// {fact rule=hardcoded-credentials@v1.0 defects=1}

function nonCompliant() {
  var crypto = require("crypto");
  function hardcodedCredentialsNoncompliant(
    salt: any,
    iterations: any,
    keyLen: any,
    digest: any,
  ) {
    // Noncompliant: password is hardcoded.
    crypto.pbkdf2(
      "password",
      salt,
      iterations,
      keyLen,
      digest,
      (err: any, key: { toString: (arg0: string) => any }) => {
        if (err) {
          throw err;
        }
        return key.toString("base64");
      },
    );
  }
}
// {/fact}

// {fact rule=hardcoded-credentials@v1.0 defects=0}

function compliant() {
  var crypto = require("crypto");
  function hardcodedCredentialsCompliant(
    salt: any,
    iterations: any,
    keyLen: any,
    digest: any,
  ) {
    // Compliant: password is obtained from environment.
    crypto.pbkdf2(
      process.env.password,
      salt,
      iterations,
      keyLen,
      digest,
      (err: any, key: { toString: (arg0: string) => any }) => {
        if (err) {
          throw err;
        }
        return key.toString("base64");
      },
    );
  }
}
// {/fact}
