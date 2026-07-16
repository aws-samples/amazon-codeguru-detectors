// {fact rule=ldap-injection@v1.0 defects=1}
public User Login(string userName, string password)
	 {
	     using (DirectoryEntry entry = new DirectoryEntry(config.Path, config.UserDomainName + "\\" + userName, password))
	     {
	         using (DirectorySearcher searcher = new DirectorySearcher(entry))
	         {
	             // Noncompliant:  improper validation or sanitization
	             searcher.Filter = String.Format("({0}={1})", SAMAccountNameAttribute, userName);
	             searcher.PropertiesToLoad.Add(DisplayNameAttribute);
	             searcher.PropertiesToLoad.Add(SAMAccountNameAttribute);
	             var result = searcher.FindOne();
	             if (result != null)
	             {
	                 var displayName = result.Properties[DisplayNameAttribute];
	                 var samAccountName = result.Properties[SAMAccountNameAttribute];
	                 
	                 return new User
	                 {
	                     DisplayName = displayName == null || displayName.Count <= 0 ? null : displayName[0].ToString(),
	                     UserName = samAccountName == null || samAccountName.Count <= 0 ? null : samAccountName[0].ToString()
	                 };
	             }
	         }
	     }
	 }
// {/fact}

// {fact rule=ldap-injection@v1.0 defects=0}
	 public User Login1(string userName, string password)
	 {
	     using (DirectoryEntry entry = new DirectoryEntry(config.Path, config.UserDomainName + "\\" + userName, password))
	     {
	         using (DirectorySearcher searcher = new DirectorySearcher(entry))
	         {
	             // Compliant:  proper validation or sanitization
	             searcher.Filter = String.Format("({0}={1})", Encoder.LdapFilterEncode(SAMAccountNameAttribute), Encoder.LdapFilterEncode(userName));
	             searcher.PropertiesToLoad.Add(DisplayNameAttribute);
	             searcher.PropertiesToLoad.Add(SAMAccountNameAttribute);
	             var result = searcher.FindOne();
	             if (result != null)
	             {
	                 var displayName = result.Properties[DisplayNameAttribute];
	                 var samAccountName = result.Properties[SAMAccountNameAttribute];
	                 
	                 return new User
	                 {
	                     DisplayName = displayName == null || displayName.Count <= 0 ? null : displayName[0].ToString(),
	                     UserName = samAccountName == null || samAccountName.Count <= 0 ? null : samAccountName[0].ToString()
	                 };
	             }
	         }
	     }
	 }
     // {/fact}