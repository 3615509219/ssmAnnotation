
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-table.min.css">
</head>
<body>
    <table id="tab"></table>
    <hr/>
    <form method="post" action="add">
        用户名字：<input type="text" id="addUserName" name="tbUsername">
        用户金额：<input type="text" id="addUserMoney" name="tbUsermoney">
        <input type="submit" value="增加">
    </form>
    <hr/>
    <form method="post" action="delete">
        用户编号：<input type="text" id="delUserId" name="tbUserid">
        <input type="submit" value="删除">
    </form>
    <hr/>
    <form method="post" action="update">
        用户编号：<input type="text" id="updUserId" name="tbUserid">
        用户名字：<input type="text" id="updUserName" name="tbUsername">
        用户金额：<input type="text" id="updUserMoney" name="tbUsermoney">
        <input type="submit" value="修改">
    </form>

<script src="static/jquery-3.5.1.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/bootstrap-table.min.js"></script>
<script src="static/bootstrap-table-zh-CN.min.js"></script>
<script>
    $(function (){
        init()
    })

    function init() {
        $('#tab').bootstrapTable({
            url: 'index',         //请求后台的URL（*）
            contentType : "application/x-www-form-urlencoded",
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams:queryParam,
            responseHandler:responseHandler,
            sidePagination: "service",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 3,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'tbUserid',
                title: '用户编号'
            }, {
                field: 'tbUsername',
                title: '用户名字'
            }, {
                field: 'tbUsermoney',
                title: '用户金额'
            }]
        })
        function queryParam(params) {
            var param = {
                limit: this.limit, // 页面大小
                offset: this.offset, // 页码
                pageNumber: this.pageNumber,
                pageSize: this.pageSize
            };
            return param;
        }
        function responseHandler(res) {
            console.log(res)
            if (res) {
                return {
                    "rows" : res.obj.list,
                    "total" : res.obj.total
                };
            } else {
                return {
                    "rows" : [],
                    "total" : 0
                };
            }
        }
    }


</script>
</body>
</html>
