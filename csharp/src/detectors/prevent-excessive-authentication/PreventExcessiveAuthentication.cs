// {fact rule=prevent-excessive-authentication@v1.0 defects=1}
public async Task<IActionResult> OnPostAsync(string returnUrl = null)
	 {
	     returnUrl = returnUrl ?? Url.Content("~/");
	 
	     if (ModelState.IsValid)
	     {
	         // Noncompliant: lockoutOnFailure us set to false
	         var result = await _signInManager.PasswordSignInAsync(Input.Email,
	             Input.Password, Input.RememberMe,
	             lockoutOnFailure: false);
	         if (result.Succeeded)
	         {
	             _logger.LogInformation("User logged in.");
	             return LocalRedirect(returnUrl);
	         }
	         if (result.RequiresTwoFactor)
	         {
	             return RedirectToPage("./LoginWith2fa", new { ReturnUrl = returnUrl,
	                 Input.RememberMe });
	         }
	         if (result.IsLockedOut)
	         {
	             _logger.LogWarning("User account locked out.");
	             return RedirectToPage("./Lockout");
	         }
	         else
	         {
	             ModelState.AddModelError(string.Empty, "Invalid login attempt.");
	             return Page();
	         }
	     }
	 
	     return Page();
	 }
	 //{fact}

    // {fact rule=prevent-excessive-authentication@v1.0 defects=0}
	 public async Task<IActionResult> OnPostAsync(string returnUrl = null)
	 {
	     returnUrl = returnUrl ?? Url.Content("~/");
	     if (ModelState.IsValid)
	     {
	         // Compliant:lockoutOnFailure is set to true
	         var result = await _signInManager.PasswordSignInAsync(Input.Email,
	             Input.Password, Input.RememberMe,
	             lockoutOnFailure: true);
	 
	         if (result.Succeeded)
	         {
	             _logger.LogInformation("User logged in.");
	             return LocalRedirect(returnUrl);
	         }
	         if (result.RequiresTwoFactor)
	         {
	             return RedirectToPage("./LoginWith2fa", new { ReturnUrl = returnUrl,
	                 Input.RememberMe });
	         }
	         if (result.IsLockedOut)
	         {
	             _logger.LogWarning("User account locked out.");
	             return RedirectToPage("./Lockout");
	         }
	         else
	         {
	             ModelState.AddModelError(string.Empty, "Invalid login attempt.");
	             return Page();
	         }
	     }
	 
	     return Page();
	 }
//{fact}