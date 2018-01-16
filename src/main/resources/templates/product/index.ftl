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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <input class="form-control" name="productId" value="${(productInfo.productId)!''}"
                               type="hidden"/>

                        <div class="form-group">
                            <label>名称</label>
                            <input type="text" class="form-control" name="productName" value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input type="text" class="form-control" name="productPrice" value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input type="number" class="form-control" name="productStock" value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input type="text" class="form-control" name="productDescription"value="${(productInfo
                            .productDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <#if (productInfo.productId)??>
                            <div><img src="${(productInfo.productIcon)!''}"  width="100" height="100"></div>
                            </#if>
                            <input type="text" class="form-control" name="productIcon" value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categories as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                    >${category.categoryName}</option>
                                </#list>

                            </select>
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