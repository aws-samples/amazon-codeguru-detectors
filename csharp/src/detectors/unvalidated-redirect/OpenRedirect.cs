[HttpPost]
	 public ActionResult LogOn(LogOnModel model, string returnUrl)
	 {
	     if (ModelState.IsValid)
	     {
	         if (MembershipService.ValidateUser(model.UserName, model.Password))
	         {
	             FormsService.SignIn(model.UserName, model.RememberMe);
	             if (!String.IsNullOrEmpty(returnUrl))
	             {
	                 // Noncompliant: open-redirect-csharp-rule
	                 return Redirect(returnUrl);
	             }
	             else
	             {
	                 return RedirectToAction("Index", "Home");
	             }
	         }
	         else
	         {
	             ModelState.AddModelError("",
	             "The user name or password provided is incorrect.");
	         }
	     }
	 }
	 
	 
	 [HttpPost]
	 public ActionResult LogOn(LogOnModel model, string returnUrl)
	 {
	     if (ModelState.IsValid)
	     {
	         if (MembershipService.ValidateUser(model.UserName, model.Password))
	         {
	             FormsService.SignIn(model.UserName, model.RememberMe);
	             if (IsLocalUrl(returnUrl))
	             {
	                 // Compliant: open-redirect-csharp-rule
	                 return Redirect(returnUrl);
	             }
	             else
	             {
	                 return RedirectToAction("Index", "Home");
	             }
	         }
	         else
	         {
	             ModelState.AddModelError("",
	             "The user name or password provided is incorrect.");
	         }
	     }
	 }
