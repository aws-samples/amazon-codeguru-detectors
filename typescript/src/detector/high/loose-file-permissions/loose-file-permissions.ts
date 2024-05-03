// {fact rule=loose-file-permissions@v1.0 defects=1}
import fs from 'fs'
function looseFilePermissionsNoncompliant() {
  // Noncompliant: read permissions assigned to others.
  fs.promises.chmod("/path", 0o774).then((r: any) => {});
}
// {/fact}

// {fact rule=loose-file-permissions@v1.0 defects=0}
import fs from 'fs'
function looseFilePermissionsCompliant() {
  // Compliant: read, write and execute permissions assigned to owner and no permission assigned to others.
  fs.promises.chmod("/path", 0o770).then((r: any) => {});
}

// {/fact}
