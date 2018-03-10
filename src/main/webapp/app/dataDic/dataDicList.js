/**
 * Created by chenyanlong on 17/2/4.
 */



var pageCur = 1;
var pageSize = 20;
// 列表数据请求url
var dataUrl = rootPath + "/dataDic/list";

$(document).ready(function () {

    // 加载数据
    loadData(pageCur, pageSize, dataUrl);
    $(".search").on('click', function () {
        loadData(pageCur, pageSize, dataUrl);
    });


});





// 获取请求服务器数据
function getServerParams() {
    var postData = {};
    // 排序字段
    postData.ddTypeName = $("#s_ddTypeName").val();
    return postData;
}
// 数据加载
function loadData(currentPage, pageSize, url) {
    var postData = getServerParams();
    postData.startRow = (currentPage - 1) * pageSize;
    postData.pageSize = pageSize;
    $.ajax({
        type: "post",
        url: url,
        dataType: 'json',
        data: postData,
        async: false,
        success: dataCallbackShow
    })
}


// 数据填充
function dataCallbackShow(data) {
    // 表单清空
    $("#lists").empty();
    $("#page").empty();
    // 数据空判断
    if (data == null || data.datas == null || data.datas.length == 0) {
        var emptyData = '<tr"><td valign="top" colspan="5" class="dataTables_empty">无符合条件数据！</td></tr>';
        $("#lists").html(emptyData);
        return;
    }
    var rowTemplate = $("#template").children();
    $.each(data.datas, function (index, item) {
        // 克隆tr模板
        var row = rowTemplate.clone();
        row.find("#index").text(index);
        row.find("#ddTypeName").text(item.ddTypeName);
        row.find("#ddValue").text(item.ddValue);
        row.find("#ddDesc").text(item.ddDesc);
        row.appendTo("#lists");
    });
    // 绑定分页方法
    paginator("#page", currentPage, pageSize, total, dataUrl);


}



function dataDicDelete(_this) {
    var ddId = $(_this).closest("td").find("#ddId").val();
    if (confirm("确定要删除这条数据字典吗?")) {
        $.post(rootPath + "/dataDic/delete", {ddId: ddId},
            function (result) {
                if (result) {
                    alert("删除成功！");
                    window.location.href = rootPath + "/dataDic/dataDicListPage";
                }
            }
        );
    }
}



function edit(_this) {
    var ddId = $(_this).closest("td").find("#ddId").val();
    Window.Location.href(rootPath + "dataDic/dataDicSavePage?ddId="+ddId);
}

/**
 * 分页方法
 *
 * @date 2016年1月12日 下午5:41:03
 * @param element
 *            jquery selector
 * @param currentPage
 * @param pageSize
 * @param totalCount
 * @param url
 */
function paginator(element, currentPage, pageSize, totalCount, url) {
    var pageCount = Math.ceil(totalCount / pageSize);
    var options = {
        currentPage: currentPage,
        totalPages: pageCount,
        bootstrapMajorVersion: 3,
        alignment: "right",
        numberOfPages: 5,
        size: "normal",
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "尾页";
                case "page":
                    return page;
            }
        },
        onPageClicked: function (event, originalEvent, type, page) {
            // 加载数据
            loadData(page, pageSize, url);
            pageCur = page;
        }
    }
    // 渲染分页模块
    $(element).bootstrapPaginator(options);
}