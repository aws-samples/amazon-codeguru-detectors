package main

import (
	"os"
	"os/exec"
)

// {fact rule=code-injection@v1.0 defects=1}
func codeInjectionNoncompliant(name string){
	var cmdPath = name
    // Noncompliant: not sanitized input is used
	cmd := &exec.Cmd{
		Path: cmdPath,
		Args: []string{ "test", "sample" },
        Stdout: os.Stdout,
        Stderr: os.Stdout,
	}

	cmd.Start()
}
// {/fact}

// {fact rule=code-injection@v1.0 defects=0}
func codeInjectionCompliant(){
    cmdPath,_ := exec.LookPath("go")
    // Compliant: not sanitized input is not used
    cmd := &exec.Cmd{
    		Path: cmdPath,
    		Args: []string{ "test", "sample" },
            Stdout: os.Stdout,
            Stderr: os.Stdout,
    	}

	cmd.Start()
}
// {/fact}