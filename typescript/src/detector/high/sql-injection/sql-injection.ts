// {fact rule=sql-injection@v1.0 defects=1}
import sql from 'mysql'
import express, { Request, Response } from 'express'
var app = express()

var connection = sql.createConnection({
    host     : 'localhost',
    user     : 'myUserName',
    password : 'myPass',
    database : 'myDatabase'
})

function sqlInjectionNoncompliant() {
    app.get("/user/:id", (req: Request, res: Response) => {
        // Noncompliant: user input is not sanitized before use.
        var query = "SELECT * FROM Employees WHERE ID = " + req.params.id

        connection.query(query, (error: any, results: any, fields: any) => {
            if (error) throw error
        })
    })
}
// {/fact}


// {fact rule=sql-injection@v1.0 defects=0}
import sql from 'mysql'
import express, { Request, Response } from 'express'
var app = express()

var connection = sql.createConnection({
    host     : 'localhost',
    user     : 'myUserName',
    password : 'myPass',
    database : 'myDatabase'
});

function sqlInjectionCompliant() {
    app.get("/user/:id", (req: Request, res: Response) => {
        // Compliant: user input is sanitized before use.
        var query = "SELECT * FROM Employees WHERE ID = " + connection.escape(req.params.id)

        connection.query(query, (error: any, results: any, fields: any) => {
            if (error) throw error
        })
    })
}
// {/fact}
