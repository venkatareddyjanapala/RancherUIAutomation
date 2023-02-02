<h1>UI automation framework using Selenium Webdriver.</h1>
<h2>Folder Structure:</h2>
<ol>
* src->main (Main class files)
* base -> contains all base classes (contains abstraction methods)
* Config -> config properties file contains all config information
* Extent Reports  -> For generation of reports
* PageHelpers -> Contains all page helpers with all Web Element locators & page actions
* Utils -> all Utility Classed

src->test
* LoginTests -> Contains all test classes having tests around login pages
Added support for both Chrome & Firefox drivers, drivers are placed under src->main->resources

</ol>
<h2>Run Configuration:</h2>
To run entire suite:
<code>
mvn test
</code>
