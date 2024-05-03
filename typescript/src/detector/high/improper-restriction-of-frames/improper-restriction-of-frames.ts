// {fact rule=improper-restriction-of-frames@v1.0 defects=1}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
function improperRestrictionOfFramesNoncompliant() {
  app.use((req: Request, res: Response) => {
    // Noncompliant: it has broken `X-Frame-Options` header.
    res.setHeader("X-Frame-Options", req.query)
  })
}
// {/fact}


// {fact rule=improper-restriction-of-frames@v1.0 defects=0}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
function improperRestrictionOfFramesCompliant() {
  app.use((req: Request, res: Response) => {
    var host = req.query.opts
    // Compliant: it has safe `X-Frame-Options` header.
    res.setHeader("X-Frame-Options", "https://example.com")
  })
}
// {/fact}