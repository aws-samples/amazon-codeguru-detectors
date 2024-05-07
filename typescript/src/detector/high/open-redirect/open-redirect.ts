// {fact rule=open-redirect@v1.0 defects=1}
import express, {Request, Response} from 'express'
var app = express()

function openRedirectNoncompliant() {
  app.get('/users/:profileUrl',function(req: Request, res: Response) {
    var url: string = req.params.url
    // Noncompliant: user input is used without sanitization.
    res.redirect(url)
  })
}
// {/fact}

// {fact rule=open-redirect@v1.0 defects=0}
import express, {Request, Response} from 'express'
var app = express()

function openRedirectCompliant() {
  const safeurl: string[] = ['www.example.com']
  app.post('/users/:profileUrl',function(req: Request, res: Response) {
    var url: string = req.params.url
    if(safeurl.includes(url)) {
      // Compliant: user input is sanitized before use.
      return res.redirect(url)
    }
    return res.redirect('/')
  })
}
// {/fact}
