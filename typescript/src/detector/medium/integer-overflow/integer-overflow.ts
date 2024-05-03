// {fact rule=integer-overflow@v1.0 defects=1}
function integerOverflowNoncompliant() {
  // Noncompliant: bigint is assigned to a variable.
  var max: number = 154327115334273650000012748329;
}
//{/fact}

// {fact rule=integer-overflow@v1.0 defects=0}
function integerOverflowCompliant() {
  // Compliant: number is passed in BigInt() method is appended to an integer which makes it a bigint.
  var max: BigInt = BigInt(154327115334273650000012748329);
}
//{/fact}
