/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */


// {fact rule=path-traversal@v1.0 defects=1}
using namespace std;
#define CROW_MAIN
#include <iostream>
#include <fstream>
#include <memory>
#include <crow_all.h>

int pathTraversalNoncompliant() {
     crow::SimpleApp app;

     CROW_ROUTE(app, "/download/<path>")
         ([](const crow::request& req, crow::response& res, const std::string& filePath) {
             ofstream file("uploads/" + filePath, ios::out);
             // Noncompliant: filepath does not properly validate.
             if (file.is_open()) {
                 std::string content((std::istreambuf_iterator<char>(file)), std::istreambuf_iterator<char>());
                 res.write(content);
                 res.end();
             } else {
                 res.code = 404;
                 res.write("File not found");
                 res.end();
             }
         });
 
     app.port(8080).multithreaded().run();
     return 0;
}

// {/fact}