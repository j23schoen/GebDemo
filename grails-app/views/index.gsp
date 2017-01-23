<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Geb Demo</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body class="container">
<h1>Geb Demo</h1>
<h4>This app is intended to provide a sort of playground for experimenting with Geb and getting comfortable with functional testing.</h4>
<h4>The dependencies are already set up so the app is ready to run. </h4>
<h4>There is a controller created with a few methods to return information about the cast of Seinfeld.</h4>
<h4>The spec file has already been created as well with 4 basic tests.</h4>

<p>To run the geb tests from the command line.. <pre><code>grails dev test-app -Dgeb.env=chromeLocal functional: GebDemoSpec</code></pre></p>
<p>The app is also configured to use chrome in the default environment, so to make life easier you can run..<pre><code>grails dev test-app functional:</code></pre></p>
<p>If you create additional tests, you can comma delimit the spec files. To run all functional tests, don't specify any files after <code>functional:</code></p>
<div id="seinfeldLink">
    <g:link controller="gebDemo" action="seinfeld">Click here to go to the Seifneld page</g:link>
</div>
<div id="formLink">
    <g:link controller="gebDemo" action="simpleFormFillout">Click here to go to the form page</g:link>
</div>

</body>
</html>