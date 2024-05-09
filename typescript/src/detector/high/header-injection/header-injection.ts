// {fact rule=header-injection@v1.0 defects=1}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
function headerInjectionNoncompliant() {
  app.get("www.example.com", function (req: Request, res: Response) {
    // Noncompliant: using untrusted user-input to set response headers.
    res.setHeader("Content-Type", req.query.type)
  })
}
// {/fact}


// {fact rule=header-injection@v1.0 defects=0}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
function headerInjectionCompliant() {
  app.get("www.example.com", function (req: Request, res: Response) {
    // Compliant: using hardcoded string value to set response headers.
    res.setHeader("Content-Type", "text/html")
  })
}
// {/fact}