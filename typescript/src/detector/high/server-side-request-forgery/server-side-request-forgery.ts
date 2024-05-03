// {fact rule=server-side-request-forgery@v1.0 defects=1}
import express, { Request, Response } from 'express'
import request from 'request'
var app = express()

function serverSideRequestForgeryNoncompliant() {
  app.get('/data/img', (req: Request, res: Response) => {
    var url = req.body.imageUrl

    // Noncompliant: user provided url is used to make a request.
    request.get(url)
  });
}
// {/fact}

// {fact rule=server-side-request-forgery@v1.0 defects=0}
import express, { Request, Response } from 'express'
import request from 'request'
var app = express()

function serverSideRequestForgeryCompliant() {
  app.get('/data/img', (req: Request, res: Response) => {
    // Compliant: url used to make a request is not user provided.
    var url = 'https://example.com'

    request.get(url)
  })
}
// {/fact}
