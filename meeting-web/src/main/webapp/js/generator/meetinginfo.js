$(function () {
    $("#jqGrid").jqGrid({
        url: '../meetinginfo/list',
        datatype: "json",
        colModel: [			
		//	{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会议编号', name: 'meetingno', index: 'meetingNo', width: 80 },
			{ label: '会议名称', name: 'meetingname', index: 'meetingName', width: 80 },
			{ label: '地点', name: 'meetinglocation', index: 'meetingLocation', width: 80 },
			{ label: '时间', name: 'meetingdate', index: 'meetingDate', width: 80 },
			{ label: '主持人', name: 'chairman', index: 'chairMan', width: 80 },
			//{ label: '', name: 'attendanceid', index: 'attendanceID', width: 80 },
			{ label: '状态', name: 'meetingstatus', index: 'meetingStatus', width: 80 }  ,
            {label: '参会名单',name:'ViewDetail',index:'detail', width:50,align:"center"}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
            //隐藏grid底部滚动条
            var ids = jQuery("#jqGrid").jqGrid('getDataIDs');

            for ( var i = 0; i < ids.length; i++) {

                var id = ids[i];
                var rowData = $("#jqGrid").getRowData(id);  //1.获取选中行的数据
//                var status = rowData.inStatus;//2.得到选中数据的某个属性
//                var meetingno = "xg0001";//rowData.meetingno;
//                        alert(meetingno)   ;
                detail ="<a href='#' style='color:#f60' onclick='ViewDetail("+ id +")' >添加参会人员</a>";

                jQuery("#jqGrid").jqGrid('setRowData', ids[i], { ViewDetail: detail });
            }
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
function ViewDetail(id) {

    //  window.location.href = "view_check_report_detail.action?checkReportId=" + id;
//alert(id);
//    var rowData = $("#jqGrid").getRowData(id);  //1.获取选中行的数据
//                var status = rowData.inStatus;//2.得到选中数据的某个属性
//    var meetingNo = rowData.meetingno;
    window.location.href = "http://localhost:8090/generator/meetingorganize.html?meetingno=" +id ;
}
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		meetingInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.meetingInfo = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.meetingInfo.id == null ? "../meetinginfo/save" : "../meetinginfo/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.meetingInfo),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../meetinginfo/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../meetinginfo/info/"+id, function(r){
                vm.meetingInfo = r.meetingInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});