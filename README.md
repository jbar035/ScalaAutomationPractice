
# cucumber-learning

This project is intended as a template or exemplar which can be extended to allow the running of Selenium tests written in Scala and driven by Cucumber feature files within the MDTP test environments.

In order to run tests using SBT a number of arguments can be provided to provide additional flexibility

System properties can be used to specify the browser type and environment against which the tests should be run.
The following options are currently supported:

```
browser = chrome / headless / firefox
environment = local / dev / qa / staging
```

The location of a specific Runner class can also be specified allowing multiple runners with specific tags to be set up  to differentiate between acceptance and smoke tests for example.

As an example, to run tests locally using chrome, the following can be run from a shell script
```
driver_path=/usr/local/bin/chromedriver
sbt -Denvironment=local -Dbrowser=chrome -Dwebdriver.chrome.driver=${driver_path} 'test-only appName.runner.Runner'
```
    
Similarly, to run tests against the QA environment using firefox, use:
    
```
driver_path=/usr/local/bin/geckodriver
sbt -Denvironment=qa -Dbrowser=firefox -Dwebdriver.gecko.driver=${driver_path} 'test-only appName.runner.Runner'
```

The latest versions of the firefox and chrome browsers and their respective drivers should be installed.
