package main

import (
    "fmt"
    "os/exec"
)

// {fact rule=os-command-injection@v1.0 defects=1}
func osInjectionWriteNoncompliant(input string) error {
    cmd := exec.Command("bash")
    cmdStdin, err := cmd.StdinPipe()
    if err!= nil {
        return err
    }
    cmd.Start()
    customCommand := fmt.Sprintf("echo %s\n", input)

    // Noncompliant: Unsanitized input is passed to `Write`.
    if _, err := cmdStdin.Write([]byte(customCommand)); err != nil {
        return err
    }
    cmd.Wait()

    return nil
}
// {/fact}

// {fact rule=os-command-injection@v1.0 defects=0}
func osInjectionWriteCompliant() error {
    cmd := exec.Command("bash")
    cmdStdin, err := cmd.StdinPipe()
    if err!= nil {
        return err
    }

    // Compliant: Hardcoded value is passed to `Write`.
    if _, err := cmdStdin.Write([]byte("echo Hello")); err != nil {
        return err
    }
    cmd.Wait()

    return nil
}
// {/fact}
