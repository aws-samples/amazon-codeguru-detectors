// {fact rule=improper-input-validation@v1.0 defects=1}
import express, { Express, Request, Response } from 'express'
var app : Express = express()

function improperInputValidationNoncompliant() {
  app.get(
    "/data/collection",
    function (request: Request, response: Response) {
      // Noncompliant: user input is not sanitized before use.
      var regex = RegExp(request.params.collection);
      regex.test(request.params.collection);
    },
  )
}
//{/fact}

// {fact rule=improper-input-validation@v1.0 defects=0}
import express, { Express, Request, Response } from 'express'
var app : Express = express()
var escapeStringRegexp = require('escape-string-regexp')

function improperInputValidationCompliant() {
  app.get(
    "/data/collection",
    (request: Request, response: Response) => {
      // Compliant: user input is sanitized before use.
      var regex = RegExp(escapeStringRegexp(request.params.collection))
      regex.test(request.params.collection)
    },
  )
}
//{/fact}
