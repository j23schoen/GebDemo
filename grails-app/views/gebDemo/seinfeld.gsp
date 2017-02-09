<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="../js/waitingfor.js"></script>
    <script src="../js/gebDemoJS.js"></script>

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
<h1 style="text-align: center;">Cojug is king</h1>
<div>&nbsp;</div>
<form class="form-horizontal">
    <div class="form-group row" id="creatorDiv">
        <label class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4" for="showCreator">Show Creator</label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <input class="form-control" id="showCreator" value="Larry David" disabled>
        </div>
        <div class="col-xs-12 col-sm-4 col-md-2 col-lg-4">
            <button type="button" class="btn btn-default" id="findCharacters">Go!</button>
        </div>
    </div>
</form>
<div class="row" id="seinfeldCharacters" style="display: none;">
    <div class="col-lg-offset-4 col-sm-offset-4 col-md-offset-4">
        <h5>Characters: </h5>
        <ul id="charactersFound"></ul>
    </div>
</div>

<form class="form-horizontal">
    <div class="form-group row" style="display: none;" id="searchByCharacterName">
        <label class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4" for="searchForName">Search by character name</label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <input class="form-control" id="searchForName" placeholder="Search for name...">
        </div>
    </div>
</form>

<form class="form-horizontal">
    <div class="form-group row" style="display: none;" id="selectNameDiv">
        <label class="control-label col-xs-12 col-sm-4 col-md-4 col-lg-4" for="selectName">Select character name</label>
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
            <select class="form-control" id="selectName">

            </select>
        </div>
    </div>
</form>

<div class="row">
    <div class="well col-lg-offset-4 col-lg-4" id="characterInfoWell" style="display: none;">
        <h5 id="characterSelected"></h5>
        <h5 id="age"></h5>
        <h5 id="netWorth"></h5>
    </div>
</div>

</body>
</html>