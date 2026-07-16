	 using Microsoft.AspNetCore.Mvc;
	 // {fact rule=mass-assignment@v1.0 defects=1}
	 public IActionResult Create(UserModel model)
	 {
	     context.SaveChanges();
	     // Noncompliant: `Bind` attribute not present
	     return View("Index", model);
	 }
	  // {fact}

     // {fact rule=mass-assignment@v1.0 defects=0}
	 public IActionResult Create([Bind(nameof(UserModel.Name))] UserModel model)
	 {
	     context.SaveChanges();
	     // Compliant: `Bind` attribute present
	     return View("Index", model);
	 }
      // {fact}