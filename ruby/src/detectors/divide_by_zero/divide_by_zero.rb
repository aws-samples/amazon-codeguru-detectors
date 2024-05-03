#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0


# {fact rule=divide-by-zero@v1.0 defects=1}
def divide_by_zero_noncompliant
  zero = 0
  # Noncompliant: divide by zero 
  bad = variable/zero
end
# {/fact}

# {fact rule=divide-by-zero@v1.0 defects=0}
def divide_by_zero_compliant
  # Compliant: check before dividing 
  if zero != 0
    variable / zero
  end
end
# {/fact}
