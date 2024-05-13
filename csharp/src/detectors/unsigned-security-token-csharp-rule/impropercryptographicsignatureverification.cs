// {fact rule=impropercryptographicsignatureverification@v1.0 defects=1}
services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>

	             {
	 
	                 options.TokenValidationParameters = new TokenValidationParameters
	                 {
	                     // Noncompliant: RequireSignedTokens to false
	                     RequireSignedTokens = false,
	                     ValidateIssuer = false,
	                     ValidateAudience = false
	                 };
	             });
	  // {/fact}

// {fact rule=impropercryptographicsignatureverification@v1.0 defects=0}
services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
            {
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    // Compliant: RequireSignedTokens to True
                    RequireSignedTokens = true,
                    ValidateIssuer = false,
                    ValidateAudience = false
                };
            });
 // {/fact}
