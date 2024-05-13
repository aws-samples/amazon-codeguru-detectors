// {fact rule=jwt-no-expiry@v1.0 defects=1}
services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
	             {
	 
	                 options.TokenValidationParameters = new TokenValidationParameters
	                 {
	                     // Noncompliant: ValidateLifetime is set to false
	                     ValidateLifetime = false,
	                     RequireSignedTokens = true,
	                     ValidateIssuer = false,
	                     ValidateAudience = false,
	                     RequireExpirationTime = true
	                 };
	             });
     // {/fact}

    // {fact rule=jwt-no-expiry@v1.0 defects=0}
	 services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
	             {
	 
	                 options.TokenValidationParameters = new TokenValidationParameters
	                 {
	                     // Compliant:  ValidateLifetime is set to true
	                     ValidateLifetime = true,
	                     RequireSignedTokens = true,
	                     ValidateIssuer = false,
	                     ValidateAudience = false,
	                     RequireExpirationTime = true
	                 };
	             });
