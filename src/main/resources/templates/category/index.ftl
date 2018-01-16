<html>
    <#include "../common/head.ftl">
<body>
<div class="toggled" id="wrapper">
<#--侧边栏-->
    <#include "../common/nav.ftl">
<#--内容栏-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <input class="form-control" name="categoryId" value="${(productCategory.categoryId)!''}"
                               type="hidden"/>
                        <div class="form-group">
                            <label>名称</label>
                            <input type="text" class="form-control" name="categoryName" value="${(productCategory.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input type="number" class="form-control" name="categoryType" value="${(productCategory
                            .categoryType)!''}"/>
                        </div>
                        <button type="submit" class="btn btn-default btn-success">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>