// {fact rule=insecure-object-attribute-modification@v1.0 defects=1}
import express, {Request, Response} from 'express'
var app = express()
function insecureObjectAttributeModificationNoncompliant() {
    app.get('www.example.com', (req: Request, res: Response) => {
        var userId = req.params.id
        // Noncompliant: external input used as object property.
        req.session.user[userId] = req.body['userDetails']
    });
}
// {/fact}


// {fact rule=insecure-object-attribute-modification@v1.0 defects=0}
import express, {Request, Response} from 'express'
var app = express()
function insecureObjectAttributeModificationCompliant() {
    app.get('www.example.com', (req: Request, res: Response) => {
        var userId = req.params.id
        // Compliant: checks the type of userId as string.
        if (typeof userId === 'string') {
            req.session.user[userId] = req.body['userDetails']
        }
    });
}
// {/fact}
