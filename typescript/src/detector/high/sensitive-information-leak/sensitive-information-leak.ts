// {fact rule=sensitive-information-leak@v1.0 defects=1}
import express, { Express } from 'express'
import helmet from 'helmet'
var app :Express = express()
function sensitiveInformationLeakNoncompliant(){
    app.use(
        helmet.referrerPolicy({
            // Noncompliant: sets the policy as no-referrer-when-downgrade.
            policy: 'no-referrer-when-downgrade'
        })
    )
}
// {/fact}


// {fact rule=sensitive-information-leak@v1.0 defects=0}
import express, { Express } from 'express'
import helmet from 'helmet'
var app :Express = express()
function sensitiveInformationLeakCompliant(){
    app.use(
        helmet.referrerPolicy({
            // Compliant: sets the policy as no-referrer.
            policy: 'no-referrer'
        })
    )
}
// {/fact}

