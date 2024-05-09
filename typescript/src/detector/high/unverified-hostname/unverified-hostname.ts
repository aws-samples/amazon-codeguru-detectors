// {fact rule=unverified-hostname@v1.0 defects=1}
import https from 'https'
function unverifiedHostnameNoncompliant() {
  var options = {
    hostname: "encrypted.google.com",
    port: 3000,
    path: "/pathname/",
    method: "POST",
    // Noncompliant: hostname is not verified.
    checkServerIdentity: function (host: any) {
      console.log("unverified hostname");
    },
  };
  var request = https.request(options, (response: any) => {
    let data = "hello";
    console.log(data);
  });
}
// {/fact}

// {fact rule=unverified-hostname@v1.0 defects=0}
import https from 'https'
function unverifiedHostnameCompliant() {
  var options = {
    hostname: "encrypted.google.com",
    port: 3000,
    path: "/pathname/",
    method: "POST",
    // Compliant: hostname is verified before using it.
    checkServerIdentity: function (host: string) {
      if (host != "github.com") {
        console.log("verified hostname");
      }
    },
  };
  var request = https.request(options, (response: any) => {
    let data = "hello";
    console.log(data);
  });
}

// {/fact}
