using System.Data.SqlClient;

namespace CSharpInjection
{
    class SQLInjection
    {
        // {fact rule=sql-injection@v1.0 defects=1}
        public void SqlInjectionNoncompliant(string sql)
        {
            using (SqlConnection connection = 
                   new SqlConnection("Data Source=(local);Initial Catalog=Northwind;Integrated Security=SSPI;")) {
                connection.Open();
                // Noncompliant: Detected a formatted string in a SQL statement.
                SqlCommand command= new SqlCommand(sql);
            }
        }
        // {/fact}
        
        // {fact rule=sql-injection@v1.0 defects=0}
        public void SqlInjectionCompliant()
        {
            using (SqlConnection connection =
                   new SqlConnection("Data Source=(local);Initial Catalog=Northwind;Integrated Security=SSPI;"))
            {
                string sql = "SELECT * FROM Customers WHERE EmployeeId = @EmployeeId";
                // Compliant: Obtain a PreparedStatement 'SqlParameter'.
                SqlCommand command = new SqlCommand(sql);
                command.Parameters.Add(new SqlParameter("@EmployeeId", System.Data.SqlDbType.Int));
            }
        }
        // {/fact}
    }
}