function getSelectVal() {
//获取后台json数据
    var url ="../selectattendance/listbydeptId/"+$("#bigname").val();
    $.ajax({
    type: "GET",
    url: url,
    datatype: "json",
    // data: JSON.stringify(vm.selectattendance),
    success: function(r){
    var ret =  JSON.parse(r);
    var smallname = $("#smallname");
    $("option", smallname).remove(); //清空原有的选项
    $.each(ret.list, function(index, array) {
    var option = "<option value='" + array['id'] + "'>" + array['username'] + "</option>";
    smallname.append(option);
    });
}
});

}
// 选择上级菜单选项触发事件
$(function() {
    getSelectVal();
    $("#bigname").change(function() {
    getSelectVal();
    });
});
//点击添加，获取选中选项的value和text
$(document).ready(function() {
    $("#add").click(function() {
        var result = $("#result");
        $("#smallname option:selected").each(function(){
            console.log($(this).val() + $(this).text());
            var option = "<option value='" + $(this).val() + "' selected=\"selected\">" + $(this).text() + "</option>";
            result.append(option);
        });
});
});
