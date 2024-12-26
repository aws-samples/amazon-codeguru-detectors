/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=insecure-connection@v1.0 defects=1}
const nodemailerClient = require("nodemailer");

let transporter = nodemailerClient.createTransport({
    service: "gmail",
    auth: {
        user: "youremail@gmail.com",
        pass: "yourpassword"
    },
    // Noncompliant: `requireTLS` is set to `false` which is insecure as it disables Transport Layer Security(TLS).
    requireTLS: false
});

console.log('Transporter created:', transporter);
// {/fact}


// {fact rule=insecure_connection@v1.0 defects=0}
const nodemailerClient = require("nodemailer");

let transporter = nodemailerClient.createTransport({
    service: "gmail",
    auth: {
        user: "youremail@gmail.com",
        pass: "yourpassword"
    },
    // Compliant: `requireTLS` is set to `true` which is secure as it enables Transport Layer Security(TLS).
    requireTLS: true
});

console.log('Transporter created:', transporter);
// {/fact}
