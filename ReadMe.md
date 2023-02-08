<h1>UI automation framework using Selenium Webdriver.</h1>
<h2>Folder Structure:</h2>
<ol>
<li>src->main (Main class files)</li>
<li> base -> contains all base classes (contains abstraction methods)</li>
<li>Config -> config properties file contains all config information</li>
<li>Extent Reports  -> For generation of reports</li>
<li>PageHelpers -> Contains all page helpers with all Web Element locators & page actions</li>
<li>Utils -> all Utility Classed</li>

<li>src->test</li>
<li>LoginTests -> Contains all test classes having tests around login pages</li>
<li>Added support for both Chrome & Firefox drivers, drivers are placed under src->main->resources</li>
</ol>

<h2>Run Configuration:</h2>
To run entire suite:
<code>
mvn clean test -Dmaven.test.skip=true 
</code>
