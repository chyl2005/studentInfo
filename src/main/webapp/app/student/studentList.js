/**
 * Created by chenyanlong on 17/2/3.
 */

var pageCur = 1;
var pageSize = 20;
// 列表数据请求url
var dataUrl = rootPath + "/student/list";


$(document).ready(function () {

    // 加载数据
    loadData(pageCur, pageSize, dataUrl);
    sexList();
    nationList();
    gradeList();
    $("#s_gradeId").change(function () {
        var gradeId = $(this).val();
        $.ajax({
            url: rootPath + "/class/getClassListByGrdeId",
            data: {gradeId: gradeId},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
                $('#s_classId').html('<option >请选择班级...</option>');
                var html = '';
                $.each(data, function (index, item) {
                    html += '<option value="' + item.classId + '">' + item.className + '</option>';
                });
                $('#s_classId').append(html);
            }
        });
    });

    $(".search").on('click', function () {
        loadData(pageCur, pageSize, dataUrl);
    });


});

function sexList() {
    $.ajax({
        url: rootPath + "/dataDic/getSexList",
        data: {},
        type: 'post',
        dataType: 'json',
        async: false,
        success: function (data) {
            $('#s_stuSex').html('<option >请选择性别...</option>');
            var html = '';
            $.each(data, function (index, item) {
                html += '<option value="' + item.ddValue + '">' + item.ddValue + '</option>';
            });
            $('#s_stuSex').append(html);
        }
    });
}


function nationList() {
    $.ajax({
        url: rootPath + "/dataDic/getNationList",
        data: {},
        type: 'post',
        dataType: 'json',
        async: false,
        success: function (data) {
            $('#s_stuNation').html('<option>请选择民族...</option>');
            var html = '';
            $.each(data, function (index, item) {
                html += '<option value="' + item.ddValue + '">' + item.ddValue + '</option>';
            });
            $('#s_stuNation').append(html);
        }
    });
}


function gradeList() {
    $.ajax({
        url: rootPath + "/grade/findAllGrades",
        data: {},
        type: 'post',
        dataType: 'json',
        async: false,
        success: function (data) {
            $('#s_gradeId').html('<option >请选择年级...</option>');
            var html = '';
            $.each(data, function (index, item) {
                html += '<option value="' + item.gradeId + '">' + item.gradeName + '</option>';
            });
            $('#s_gradeId').append(html);
        }
    });
}

// 获取请求服务器数据
function getServerParams() {
    var postData = {};
    // 排序字段
    postData.stuNo = $("#s_stuNo").val();
    postData.stuName = $("#s_stuName").val();
    postData.stuSex = $("#s_stuSex").val();
    postData.stuNation = $("#s_stuNation").val();
    postData.gradeId = $("#s_gradeId").val();
    postData.classId = $("#s_classId").val();
    postData.startBirthday = $("#s_b_stuBirthday").val();
    postData.endBirthday = $("#s_e_stuBirthday").val();
    postData.startRxsj = $("#s_b_stuRxsj").val();
    postData.endRxsj = $("#s_e_stuRxsj").val();
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
        var emptyData = '<tr"><td valign="top" colspan="9" class="dataTables_empty">无符合条件数据！</td></tr>';
        $("#lists").html(emptyData);
        return;
    }
    var rowTemplate = $("#template").children();
    $.each(data.datas, function (index, item) {
        // 克隆tr模板
        var row = rowTemplate.clone();
        row.find("#index").text(index);
        row.find("#stuNo").text(item.stuNo);
        row.find("#stuName").text(item.stuName);
        row.find("#stuSex").text(item.stuSex);
        row.find("#stuBirthday").text(item.stuBirthday);
        row.find("#stuRxsj").text(item.stuRxsj);
        row.find("#className").text(item.className);
        row.find("#gradeName").text(item.gradeName);
        row.find("#studentId").val(item.studentId);
        row.appendTo("#lists");
    });
    // 绑定分页方法
    paginator("#page", currentPage, pageSize, total, dataUrl);


}


function stuShow(_this) {
    var studentId = $(_this).closest("td").find("#studentId").val();
    Window.Location.href(rootPath + "/student/showPage");
}


function del(_this) {
    var studentId = $(_this).closest("td").find("#studentId").val();
    var postData = {};
    postData.studentId = studentId;
    $.ajax({
        type: 'post',
        url: rootPath + "/student/delete",
        dataType: 'json',
        async: false,
        data: postData,
        success: function (data) {

        }
    });
}


function edit(_this) {
    var studentId = $(_this).closest("td").find("#studentId").val();
    Window.Location.href(rootPath + "/student/savePage?studentId="+studentId);
}


function resetValue() {
    $("#s_stuNo").val("");
    $("#s_stuName").val("");
    $("#s_stuSex").val("-1");
    $("#s_stuNation").val("-1");
    $("#s_gradeId").val("-1");
    $("#s_classId").val("-1");
    $("#s_b_stuBirthday").val("");
    $("#s_e_stuBirthday").val("");
    $("#s_b_stuRxsj").val("");
    $("#s_e_stuRxsj").val("");
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