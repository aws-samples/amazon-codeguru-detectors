// {fact rule=origins-verified-cross-origin-communications@v1.0 defects=1}
function originsVerifiedCrossOriginCommunicationsNoncompliant() {
  var iframe = document?.querySelector(".testiframe") as HTMLIFrameElement;
  // Noncompliant: the wildcard keyword `*` is used.
  iframe?.contentWindow?.postMessage("secret_value", "*");
}
// {/fact}

// {fact rule=origins-verified-cross-origin-communications@v1.0 defects=0}
function originsVerifiedCrossOriginCommunicationsCompliant() {
  var iframe = document?.querySelector(".testiframe") as HTMLIFrameElement;
  // Compliant: using secure origin.
  iframe?.contentWindow?.postMessage(
    "secret_value",
    "https://secure.example.com",
  );
}

// {/fact}
