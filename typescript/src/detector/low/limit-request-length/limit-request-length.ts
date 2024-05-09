// {fact rule=limit-request-length@v1.0 defects=1}
import express from 'express'
var app = express()
var bodyParser = require('body-parser')
function limitOnRequestContentLengthNoncompliant() {
  // Noncompliant: limit on request content length is > 2mb in a requests.
  app.use(bodyParser.urlencoded({ extended: false, limit: "4mb" }));
}
//{/fact}

// {fact rule=limit-request-length@v1.0 defects=0}
import express from 'express'
var app = express()
var bodyParser = require('body-parser')
function limitOnRequestContentLengthCompliant() {
  // Compliant: limit on request content length is <= 2mb requests.
  app.use(bodyParser.urlencoded({ extended: false, limit: "1mb" }));
}
//{/fact}
