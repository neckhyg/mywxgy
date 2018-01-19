$(function () {
    $("#jqGrid").jqGrid({
        url: '../meetingrecord/list',
        datatype: "json",
        colModel: [			
//			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '会议编号', name: 'meetingno', index: 'meetingNO', width: 80 },
			{ label: '会议名称', name: 'meetingname', index: 'meetingName', width: 80 },
			{ label: '地点', name: 'meetinglocation', index: 'meetingLocation', width: 80 },
			{ label: '时间', name: 'meetingdate', index: 'meetingDate', width: 80 },
			{ label: '主持人', name: 'chairman', index: 'chairMan', width: 80 },
			{ label: '工号', name: 'attendanceid', index: 'attendanceID', width: 80 },
			{ label: '姓名', name: 'attendancename', index: 'attendanceName', width: 80 },
			{ label: '签到时间', name: 'signdate', index: 'signDate', width: 80 },
			{ label: '签到状态', name: 'signstatus', index: 'signStatus', width: 80 }
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
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		meetingRecord: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.meetingRecord = {};
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
			var url = vm.meetingRecord.id == null ? "../meetingrecord/save" : "../meetingrecord/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.meetingRecord),
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
				    url: "../meetingrecord/delete",
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
			$.get("../meetingrecord/info/"+id, function(r){
                vm.meetingRecord = r.meetingRecord;
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