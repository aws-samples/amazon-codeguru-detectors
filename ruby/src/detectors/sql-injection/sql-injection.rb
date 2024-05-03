=begin
Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
SPDX-License-Identifier: Apache-2.0
=end

# {fact rule=sql-injection@v1.0 defects=1}
require 'pg'

def sql_injection_noncompliant(event:, context:)
  conn = PG::Connection.open(:dbname => 'test')

  # Noncompliant: User-controlled parameter is used in SQL Statement.
  res2 = conn.exec_params('SELECT * FROM foobar WHERE id = %{id}' % {id: event['id']})
  
end
# {/fact}

# {fact rule=sql-injection@v1.0 defects=0}
require 'pg'

def sql_injection_compliant(event:, context:)
  conn = PG::Connection.open(:dbname => 'test')

  # Compliant: Parameterized SQL Statement.
  res = conn.exec_params('SELECT $1 AS a, $2 AS b, $3 AS c', [event['id'], 2, nil])
  
end
# {/fact}
