// {fact rule=sendfile-injection@v1.0 defects=1}
import express, { Express, Request, Response } from 'express'
var app :Express = express()
function sendfileInjectionNoncompliant() {
  app.get('www.example.com', (req: Request, res: Response) => {
    var fileName = req.params.file
    // Noncompliant: tainted-data is passed into 'res.sendfile'.
    res.sendFile(fileName)
  })
}
// {/fact}


// {fact rule=sendfile-injection@v1.0 defects=0}
import express, { Express, Request, Response } from 'express'
var app :Express = express()
function sendfileInjectionCompliant() {
  app.get('www.example.com', (req: Request, res: Response) => {
    var fileName = "file.txt"
    if (fileName !== req.params.file) {
      // Compliant: validated fileName before passing into 'res.sendFile'.
      res.sendFile(fileName)
      console.log("Valid file name.")
    } else {
      throw new Error("Invalid file name.")
    }
  })
}
// {/fact}