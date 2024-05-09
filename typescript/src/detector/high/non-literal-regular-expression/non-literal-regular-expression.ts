// {fact rule=non-literal-regular-expression@v1.0 defects=1}
import express, {Request, Response} from 'express'
var app = express()
function nonLiteralRegularExpressionNoncompliant() {
  app.get("www.example.com", (req: Request, res: Response) => {
    var re = new RegExp("ab+c");
    // Noncompliant: user-controlled data passes into `test` for regex patterns.
    var test = re.test(req.body.id);
  });
}
// {/fact}

// {fact rule=non-literal-regular-expression@v1.0 defects=0}

import express, {Request, Response} from 'express'
import escapeStringRegexp from 'escape-string-regexp'
var app = express()
function nonLiteralRegularExpressionCompliant() {
  app.get("www.example.com", (req: Request, res: Response) => {
    var re = new RegExp("ab+c");
    // Compliant: sanitized user-controlled data passes into `test` for regex patterns.
    var test = re.test(escapeStringRegexp(req.body.id));
  });
}
// {/fact}
