/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: MIT-0
 */

// {fact rule=untrusted-control-sphere@v1.0 defects=1}
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ServiceLoader;
import javax.servlet.http.HttpServletRequest;

public class UntrustedControlSphereNonCompliant {

    public void nonCompliant(HttpServletRequest request) throws IllegalAccessException {
        String className = request.getParameter("className");
        URL[] urls = new URL[]{new URL(request.getParameter("codebase"))};
        URLClassLoader loader = new URLClassLoader(urls);
        // Noncompliant: Loading classes from user-controlled location allows attackers to supply malicious code.
        Class<?> loadedClass = loader.loadClass(className);
        Object instance = loadedClass.newInstance();
    }
}
// {/fact}
