// {fact rule=cross-site-scripting@v1.0 defects=1}
function crossSiteScriptingNoncompliant() {
  let url = window.location.search.slice(1)

  // Noncompliant: unsafe jQuery ajax request.
  $.ajax({url: url, data: "Hello"})
}
// {/fact}

// {fact rule=cross-site-scripting@v1.0 defects=0}
import ESAPI from 'node-esapi'

function crossSiteScriptingCompliant() {
  let url = window.location.search.slice(1)

  // Compliant: url is sanitized before ajax call.
  url = ESAPI.encoder().encodeForURL(url)

  $.ajax({url: url, data: "Hello"})
}
// {/fact}
