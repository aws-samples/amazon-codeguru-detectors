using System;

namespace RazorVulnerableApp.Controllers;

public class HomeController : Controller
{
    //{fact rule=code-injection@v1.0 defects=1}
    [HttpPost]
    [ValidateInput(false)]
    public ActionResult Index(string inert, string razorTpl)
    {
        // Noncompliant: user controlled string is directly passed to `Razor.Parse`.
        ViewBag.RenderedTemplate = Razor.Parse(razorTpl);
        ViewBag.Template = razorTpl;
        return View();
    }
    //{/fact}
    private ActionResult View()
    {

        throw new NotImplementedException();
    }

    //{fact rule=code-injection@v1.0 defects=0}
    [HttpPost]
    [ValidateInput(false)]
    public ActionResult Index2(string inter, string razorTpl)
    {
        string razorTpl2 = someFunction(razorTpl);
        // Compliant: user controlled string is not directly passed to `Razor.Parse`.
        ViewBag.RenderedTemplate = Razor.Parse(razorTpl2);
        ViewBag.Template = razorTpl;
        return View();
    }
    //{/fact}

    private string someFunction(string razorTpl)
    {
        // some code
        return razorTpl;
    }
}
