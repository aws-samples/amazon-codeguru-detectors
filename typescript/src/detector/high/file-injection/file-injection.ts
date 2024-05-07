function sanitize(x: any): boolean {
  return true;
}

// {fact rule=file-injection@v1.0 defects=1}
import * as fs from 'fs'
import express, { Express, Request, Response } from 'express'
const app: Express = express()
function fileInjectionNoncompliant() {
  app.get('www.example.com', (req: Request, res: Response) => {
    var data = req.params.data
    // Noncompliant: writing unsanitized user data to a file.
    fs.writeFile('data.txt', data, function(err: any){
      if(err) throw err
    })
  })
}
// {/fact}


// {fact rule=file-injection@v1.0 defects=0}
import * as fs from 'fs'
import express, { Express, Request, Response } from 'express'
const app: Express = express()
function fileInjectionCompliant() {
  app.get('www.example.com', (req: Request, res: Response) => {
    var data = sanitize(req.params.data)
    // Compliant: user input is sanitized before use.
    fs.writeFile('data.txt', data, function(err: any){
      if(err) throw err
    })
  })
}
// {/fact}