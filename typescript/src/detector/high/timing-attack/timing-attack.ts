// {fact rule=timing-attack@v1.0 defects=1}
import express, {Request, Response} from 'express'
var app = express()
const password = "myPass";
function timingAttackNoncompliant() {
  app.get("/user/login", function (req: Request, res: Response) {
    // Noncompliant: '===' operator is used with sensitive data field.
    if (password === "myPass") {
      // logIn()
    }
  });
}
// {/fact}

// {fact rule=timing-attack@v1.0 defects=0}
import express, {Request, Response} from 'express'
var app = express()
var compare = require("secure-compare");
function timingAttackCompliant() {
  app.get("/user/login", function (req: Request, res: Response) {
    // Compliant: sensitive data field is compared using 'secure-compare'.
    if (compare(password, "myPass")) {
      //
    }
  });
}
// {/fact}
