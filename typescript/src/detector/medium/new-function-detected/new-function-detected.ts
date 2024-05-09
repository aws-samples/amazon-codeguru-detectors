// {fact rule=new-function-detected@v1.0 defects=1}
import express, {Request, Response} from 'express'
var app = express()
function newFunctionDetectedNoncompliant() {
  app.post("www.example.com", (req : Request, res : Response) => {
    // Noncompliant: passing arbitrary user-input to new 'Function()'.
    var newFunc = new Function(req.body);
    newFunc();
  });
}
//{/fact}

// {fact rule=new-function-detected@v1.0 defects=0}
import express, {Request, Response} from 'express'
var app = express()
function newFunctionDetectedCompliant() {
  app.post("www.example.com", (req : Request, res : Response) => {
    var value = "test";
    // Compliant: passing hardcoded value to new 'Function()'.
    var newFunc = new Function("alert(value)");
    newFunc();
  });
}
//{/fact}
