// {fact rule=insecure-cookie@v1.0 defects=1}
import express, { Express, Request, Response } from 'express'
import cookieSession from 'cookie-session'
var app: Express = express()
function insecureCookieNoncompliant() {
  let session = app.use(
    cookieSession({
      name: "session",
      secret: "secret",
      // Noncompliant: setting `httpOnly` to false makes cookie insecure.
      httpOnly: false,
    }),
  );
}
// {/fact}

// {fact rule=insecure-cookie@v1.0 defects=0}
import express, { Express, Request, Response } from 'express'
import cookieSession from 'cookie-session'
var app: Express = express()
function insecureCookieCompliant() {
  // Compliant: by default `httpOnly` is set to true and thus makes cookie secure.
  let session = app.use(
    cookieSession({
      name: "session",
      secret: "secret",
    }),
  );
}

// {/fact}
