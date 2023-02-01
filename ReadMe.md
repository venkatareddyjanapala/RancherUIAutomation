Folder Structure:
src->main (Main class files)
* base -> contains all base classes (contains abstraction methods)
* Config -> config properties file contains all config information
* Extent Reports  -> For generation of reports
* PageHelpers -> Contains all page helpers with all Web Element locators & page actions
* Utils -> all Utility Classed

src->test
* LoginTests -> Contains all test classes having tests around login pages
Added support for both Chrome & Firefox drivers, drivers are placed under src->main->resources
