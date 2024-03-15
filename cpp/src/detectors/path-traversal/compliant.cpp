/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=path-traversal@v1.0 defects=0}
using namespace std;
#define CROW_MAIN
#include <iostream>
#include <fstream>
#include <memory>
#include <crow_all.h>

int pathTraversalCompliant() {
     crow::SimpleApp app;
 
     CROW_ROUTE(app, "/download/<path>")
         ([](const crow::request& req, crow::response& res, const std::string& filePath) {
             if (isValidFilePath(filePath)) {
                 std::ifstream file("uploads/" + filePath);
                 // Compliant: filepath is properly validated.
                 if (file.is_open()) {
                     std::string content((std::istreambuf_iterator<char>(file)), std::istreambuf_iterator<char>());
                     res.write(content);
                     res.end();
                 } else {
                     res.code = 404;
                     res.write("File not found");
                     res.end();
                 }
             } else {
                 res.code = 400;
                 res.write("Bad Request: Invalid file path");
                 res.end();
             }
         });
 
     app.port(8080).multithreaded().run();
     return 0;
 }

// {/fact}