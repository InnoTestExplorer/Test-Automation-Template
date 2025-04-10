# Selenium Template with POM

## A complete template on Selenium on Java to rapid test automation initialization

This is a template for making web automation based on Selenenium Java, built with Maven & TestNg, for a rapid configuration for projects. 

You can run the WebDriver on the 4 supported browsers (Chrome, Edge, Safari & Firefox) in Selenium in headless mode or not. It makes it easy to create Pages (using Page Object Model) and PageTests. 

In order to create the pages and tests classes, you need the following:

  * create a Page.class (for example, ShoppigPage) that inherits from the BasePage class, overwrite the abstract methods "verifyPage()" and "WaitPageToLoad()" (The methods to call an Explicit wait its in BasePage) and write all the methods that Selenium needs to make actions, example: "fillUserData()"
  
  * create a method in CommonFlows to package the navigation of the driver, so for example, to go to "example.com", write the method "goToExamplePage()" and use the private method "getDriver()" inside CommonFlows to direct the driver to your page.
  
  * create a PageTests.class (This class should inherit from the BaseTest class), and call the Page.class that you need with the next line: 

    private final LoginPage loginPage = new LoginPage();

  and you should implement the method "@BeforeMethod(always runs = true)" where you write the preconditions that apply to all the tests on the class.

<h4>How to run it in headless mode or choose the browser</h4>

First, you need to go to all the tests that you want to run and after the @Test annotation, write (groups = {'execution'} where execution is the keyword in your shell script. 

If you want to select an especific browser, you need it to write in a shell script. 

Next, create a shell script with the following commands: 

  ./mvnw clean test -Dgroups="yourKeyword" -Dbrowser="yourSelectedBrowser"

And for headless mode, add the command to your shell script: -Dheadless. 

Save it inside your project, and run the shell script in a console 

  ./runSuite.sh

And now you got it. 

<h3>Installation</h3>

Just clone it in your IDE. 
