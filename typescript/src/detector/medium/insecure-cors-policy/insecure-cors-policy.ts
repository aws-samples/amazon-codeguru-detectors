// {fact rule=insecure-cors-policy@v1.0 defects=1}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
function insecureCorsPolicyNoncompliant() {
  app.post( "/users", function ( req: Request, res: Response ) {
      const origin = req.query.origin;
      // Noncompliant: the Access-Control-Allow-Origin header is set to user-controlled any domain.
      res.set(200, { "Access-Control-Allow-Origin": origin })
    },
  );
}
//{/fact}

// {fact rule=insecure-cors-policy@v1.0 defects=0}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
function insecureCorsPolicyCompliant() {
  app.post( "/users", function (req: Request, res: Response ) {
      // Compliant: the Access-Control-Allow-Origin header is set to allow only a specific list of trusted domains.
      res.set(200, { "Access-Control-Allow-Origin": "trustedsite.com" })
    },
  );
}
//{/fact}
