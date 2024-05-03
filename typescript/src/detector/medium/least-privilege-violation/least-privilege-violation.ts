// {fact rule=least-privilege-violation@v1.0 defects=1}
import { BrowserWindow } from 'electron'

function leastPrivilegeViolationNoncompliant() {
  var win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      // Noncompliant: 'nodeIntegration' and 'allowRunningInsecureContent' properties are enabled.
      nodeIntegration: true,
      allowRunningInsecureContent: true,
    },
  });
}
// {/fact}

// {fact rule=least-privilege-violation@v1.0 defects=0}
import { BrowserWindow } from 'electron'
function leastPrivilegeViolationCompliant() {
  var win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      // Compliant: 'nodeIntegration' and 'allowRunningInsecureContent' properties are disabled.
      nodeIntegration: false,
      allowRunningInsecureContent: false,
    },
  });
}
// {/fact}
