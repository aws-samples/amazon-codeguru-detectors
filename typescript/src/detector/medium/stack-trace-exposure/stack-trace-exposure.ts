// {fact rule=stack-trace-exposure@v1.0 defects=1}
import express, {Request, Response} from 'express'
var app = express()
function stackTraceExposureNoncompliant() {
  app.get("www.example.com", (req: Request, res: Response) => {
    try {
      throw new Error("");
    } catch (e: unknown | any) {
      var stackTrace = e.stack || e.stacktrace;
    }
    // Noncompliant: it is returning exception.
    res.send(stackTrace);
  });
}
//{/fact}

// {fact rule=stack-trace-exposure@v1.0 defects=0}
import express, {Request, Response} from 'express'
var app = express()
function stackTraceExposureCompliant() {
  app.get(
    "www.example.com",
    (req: Request, res: Response) => {
      try {
        throw new Error("");
      } catch (e: unknown | any) {
        var stackTrace = e.stack || e.stacktrace;
      }
      // Compliant: it is not returning exception.
      res.send("foo");
    },
  );
}
//{/fact}
