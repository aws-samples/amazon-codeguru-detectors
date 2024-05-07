// {fact rule=logging-of-sensitive-information@v1.0 defects=1}
import { Signale } from 'signale'

function loggingOfSensitiveInformationNoncompliant() {
  var options = {
    disabled: false,
    interactive: false,
    logLevel: "info",
    scope: "custom",
    // Noncompliant: empty list is assigned to 'secrets'.
    secrets: [],
  };
  const info = "s";
  const logger = new Signale(options);
  logger.log("Secret is: ", info);
}
// {/fact}

// {fact rule=logging-of-sensitive-information@v1.0 defects=0}
import { Signale } from 'signale'

function loggingOfSensitiveInformationCompliant() {
  var options = {
    disabled: false,
    interactive: false,
    logLevel: "info",
    scope: "custom",
    // Compliant: pattern for 'secrets' is configured and hence will not be logged.
    secrets: ["[1-9]{10}"],
  };
  const info = "ss";
  const logger = new Signale(options);
  logger.log("Secret is: ", info);
}

// {/fact}
