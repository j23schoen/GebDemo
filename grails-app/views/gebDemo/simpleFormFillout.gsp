<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <script src="../js/gebDemoJS.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="../js/waitingfor.js"></script>

    <script>
        $(document).ready(function(){
            gebDemo.init();
        });
        var appContextPath = "<%=request.getContextPath()%>";
    </script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>

<body class="container">
<a href="${createLink(uri: '/')}">Home</a>
<h1 style="text-align: center;">Form Completion</h1>
<div>&nbsp;</div>
<form class="form-horizontal">
    <div class="form-group row">
        <label for="firstName" class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4">First Name: </label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <input name="firstName" id="firstName" class="form-control"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="lastName" class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4">Last Name:</label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <input name="lastName" id="lastName" class="form-control"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="age" class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4">Age: </label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <input name="age" id="age" class="form-control"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="favoriteLanguage" class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4">Favorite Language: </label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <select name="favoriteLanguage" class="form-control" id="favoriteLanguage">
                <option value="java">Java</option>
                <option value="groovy">Groovy</option>
                <option value="c#">C#</option>
                <option value="java">Scala</option>
            </select>
        </div>
    </div>

    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-offset-4">
        <button type="button" class="btn btn-primary pull-right" id="submit">Submit</button>
    </div>

</form>

<h3 id="success" style="color: green; text-align: center; display: none;">Form Submitted</h3>
</body>
</html>