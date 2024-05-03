// {fact rule=xpath-injection@v1.0 defects=1}
import express, {Request, Response} from 'express'
import * as xpath from 'xpath'
import {DOMParser} from 'xmldom'
var app = express();
function xpathInjectionNoncompliant() {
  app.get(
    "www.example.com",
    function (req: Request, res: Response) {
      var userName = req.params.userName;
      var xml = "<book><title>Harry Potter</title></book>";
      var doc = new DOMParser().parseFromString(xml);
      // Noncompliant: passing user-input directly in an XPath expression.
      var nodes = xpath.select("//title" + userName, doc);
    },
  );
}
// {/fact}

// {fact rule=xpath-injection@v1.0 defects=0}
import express, {Request, Response} from 'express'
import * as xpath from 'xpath'
import {DOMParser} from 'xmldom'
var app = express();
function xpathInjectionCompliant() {
  app.get(
    "www.example.com",
    function (req: Request, res: Response) {
      var userName = req.params.userName;
      var xml = "<book><title>Harry Potter</title></book>";
      var doc = new DOMParser().parseFromString(xml);
      // Compliant: passing sanitized user-input in an XPath expression.
      var nodes = xpath.select("//title" + escape(userName), doc);
    },
  );
}

// {/fact}
