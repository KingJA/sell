<html>
<head>
    <meta charset="UTF-8">
    <title>错误提示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link f="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="fav.ico" type="image/x-icon"/>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    错误!
                </h4> <strong>${msg!""}</strong><a href="${url}" class="alert-link">2秒后自动跳转</a>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    setTimeout('location.href="${url}"', 2000)
</script>
</html>