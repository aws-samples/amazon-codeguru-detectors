// {fact rule=cross-site-request-forgery@v1.0 defects=1}
import express, { Request, Response } from 'express'
var app = express()

function crossSiteRequestForgeryNoncompliant() {
    app.get("/", (req: Request, res: Response) => {
        // Noncompliant: `sameSite` is set to 'none'.
        res.cookie('cookieName', 'cookieValue', { sameSite: 'none', secure: true })
        res.render("index.html")
    })
}
// {/fact}


// {fact rule=cross-site-request-forgery@v1.0 defects=0}
import express, { Request, Response } from 'express'
var app = express()

function crossSiteRequestForgeryCompliant() {
    app.get("/", (req: Request, res: Response) => {
        // Compliant: `sameSite` is set to 'lax'.
        res.cookie('cookieName', 'cookieValue', { sameSite: 'lax', secure: true })

        res.render("index.html")
    })
}
// {/fact}
