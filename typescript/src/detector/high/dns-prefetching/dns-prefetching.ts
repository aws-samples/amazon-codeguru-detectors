// {fact rule=dns-prefetching@v1.0 defects=1}
import express, { Express } from 'express'
import helmet from 'helmet'
const app: Express = express()

function dnsPrefetchingNoncompliant() {
    app.use(
        helmet.dnsPrefetchControl({
            // Noncompliant: 'allow' is set to 'true'.
            allow: true
        })
    )
}
// {/fact}


// {fact rule=dns-prefetching@v1.0 defects=0}
import express, { Express } from 'express'
import helmet from 'helmet'
const app: Express = express()

function dnsPrefetchingCompliant() {
    app.use(
        helmet.dnsPrefetchControl({
            // Compliant: 'allow' is set to 'false'.
            allow: false
        })
    )
}
// {/fact}