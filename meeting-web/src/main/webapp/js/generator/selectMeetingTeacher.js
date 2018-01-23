$(function(){
    $.post("../meetingorganize/list2",
        //                {selectId:1},
        function(r){
            //var data =  JSON.parse(r);
            $("#deptName").empty();
            var str="";

            for(var i=0;i<r.list2.length;i++){
                str+="<option value='"+r.list2[i].deptno+"'>"+r.list2[i].deptname+"</option>"
            }
            //	alert(str);
            $("#deptName").html(str);
            $("#deptName").val(01);
        },
        "json");
});

function getQueryStringV(vhref, name) {
    // 如果链接没有参数，或者链接中不存在我们要获取的参数，直接返回空
    if (vhref.indexOf("?") == -1 || vhref.indexOf(name + '=') == -1) {
        return null;
    }
    // 获取链接中参数部分
    var queryString = vhref.substring(vhref.indexOf("?") + 1);
    // 分离参数对 ?key=value&key2=value2
    var parameters = queryString.split("&");
    var pos, paraName, paraValue;
    for (var i = 0; i < parameters.length; i++) {
        // 获取等号位置
        pos = parameters[i].indexOf('=');
        if (pos == -1) {
            continue;
        }
        // 获取name 和 value
        paraName = parameters[i].substring(0, pos);
        paraValue = parameters[i].substring(pos + 1);

        if (paraName == name) {
            return unescape(paraValue.replace(/\+/g, " "));
        }
    }
    return null;
}

var vm=new Vue({
    el: '#rrapp',
    data: {
        selected:"A"
        , deptName:"1"
    }  ,
        computed:{
        options:function(){
            var array= [
                { text: 'One', value: 'A' },
                { text: 'Two', value: 'B' },
                { text: 'Three', value: 'C' }
            ];
            return array;
        }
    } ,
     methods: {
         getSelectDeptNO:function(){
//                this.deptName = deptNo;

//             alert(this.deptName);
             var url ="../meetingteacher/listbydeptno/"+ this.deptName;
             $.ajax({
                 type: "GET",
                 url: url,
                 datatype: "json",
                 // data: JSON.stringify(vm.selectattendance),
                 success: function(r){
//                     var ret =  JSON.parse(r);
                     var teachername = $("#teachername");
                     $("option", teachername).remove(); //清空原有的选项
                     $.each(r.list, function(index, array) {
                         var option = "<option value='" + array['userid'] + "'>" + array['name'] + "</option>";
                         teachername.append(option);
                     });
                 }
             });
            },
         getSelectVal:function() {

          } ,
         addTeacher:function(){
             var result = $("#result");
             $("#teachername option:selected").each(function(){
//            console.log($(this).val() + $(this).text());
                 var option = "<option value='" + $(this).val() + "' selected=\"selected\">" + $(this).text() + "</option>";
                 result.append(option);
                 });
             } ,
         outputAttendance:function(){
                 var meetingno = getQueryStringV(location.href, "meetingno");
                 var teacherIdList = [];
                 var teacherNameList = [];
                 $('#result :selected').each(function(i, selected) {
                     teacherIdList[i] = $(selected).val();
                     teacherNameList[i] = $(selected).text();
                 });
                 var data = "meetingno="+ meetingno +"&idGroup="+teacherIdList+"&nameGroup="+teacherNameList;
                    var url ="../meetingrecord/groupsave";
                    $.ajax({
                        type: "GET",
                        url: url,
                        data: data,
                        datatype: "json",
                        // data: JSON.stringify(vm.selectattendance),
                        success: function(r){
                            if(r.code === 0){
                                alert('会议名单生成成功！', function(index){
//                                    vm.reload();
                                    window.location.href = "../generator/meetingrecord.html"
                                });
                            }else{
                                alert("会议名单生成失败！");
                            }
                        }
                    });
         }


       }


});