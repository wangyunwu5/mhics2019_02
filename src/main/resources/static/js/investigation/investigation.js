var params1 = { container: '#container1'};new UploadImg(params1);
var params2 = { container: '#container2'};new UploadImg(params2);
var params3 = { container: '#container3'};new UploadImg(params3);
var params4 = {container: '#container4'};new UploadImg(params4);
var cover = {container: '#coverCondition'};new UploadImg(cover);
var ladder = {container: '#ladderCondition'};new UploadImg(ladder);
var shaft = {container: '#shaftCondition'};new UploadImg(shaft);
var chamber = {container: '#chamberCondition'};new UploadImg(chamber);
var benching = {container: '#benchingCondition'};new UploadImg(benching);
var others = {container: '#othersCondition'};new UploadImg(others);
//控制六个图片按钮是否显示
$(".condition").each(function(){
	$(this).change(function(){
		var value = $(this).val();
		var name = $(this).attr("name");
		if(value =="否"){
			$("#"+name).parent().css("display","none")
		}
		else{
			$("#"+name).parent().css("display","block")
		}
	});
});
//是否在斜坡
$(".slopeNo").change(function(){
	var value = $(this).val();
	console.log("斜坡起反应了"+value);
	var name = $(this).attr("name");
	if(value =="否"){
		$("#"+name).parent().css("display","none")
	}
	else{
		$("#"+name).parent().css("display","block")
	}
});
function showModel() {
    document.getElementById('map').style.display = 'block';
}
function closeModel() {
    document.getElementById('map').style.display = 'none';
}
function saveValue(){
	document.getElementById("zuobiao").value = document.getElementById("coordinate").value;
    document.getElementById('map').style.display = 'none';
}
var map = new BMap.Map("container");
map.centerAndZoom("深圳市", 13);
map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));   //右下角，打开
map.addEventListener("click",function(e){
	 document.getElementById("coordinate").value = e.point.lng + "," + e.point.lat;
	 map.clearOverlays();//清空原来的标注
	 var marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat));  // 创建标注，为要查询的地方对应的经纬度
	 map.addOverlay(marker);
});

var localSearch = new BMap.LocalSearch(map);
localSearch.enableAutoViewport(); //允许自动调节窗体大小
function searchByStationName() {
	map.clearOverlays();//清空原来的标注
	var keyword = document.getElementById("address").value;
	localSearch.setSearchCompleteCallback(function (searchResult) {
	    var poi = searchResult.getPoi(0);
	    document.getElementById("coordinate").value = poi.point.lng + "," + poi.point.lat;
	    map.centerAndZoom(poi.point, 13);
	    var marker = new BMap.Marker(new BMap.Point(poi.point.lng, poi.point.lat));  // 创建标注，为要查询的地方对应的经纬度
	    map.addOverlay(marker);
	});
	localSearch.search(keyword);
}
$('#to_xiugai').on('click',function(){
	var value = $('.bodyone').css('display');
	console.log("value="+value);
	if(value=="block"){
		$('.bodyone').css('display', 'none');
		$('.bodytwo').css('display', 'block');
		$(this).css('border','1px solid #337ab7');
	}else{
		$('.bodyone').css('display', 'block');
		$('.bodytwo').css('display', 'none');
		$(this).css('border','none');
	}
});
$('.only-nodeno').on('blur',function(){
	$.post("onlynodeno",{"nodeno":$(this).val()},function(data){
		console.log("唯一编号数据："+data);
		$(".onlynodeno").val(data);
	});
});
$('.only-nodeno').focus(function(){
	$(this).parent().removeClass("has-error has-feedback");
	$('.alert-danger').css('display', 'none');
});
//添加管道事件
$('.addpipe').on('click',function(){
	var td=$('.pipe-table-body').find('tr:last').find('td').eq(0);
	var i=Number(td.text())+1;
	var a=Number(td.text());
	console.log("文字内容为："+i);
	let tr = '<tr><td>'+i+'</td><td><input name="dcpipe['+a+'].pipeNo" class="" value="" placeholder="待输入"/></td>' +
			'<td><input name="dcpipe['+a+'].pipeType" list="pipetype" class="" value="" placeholder="待输入"/>'+
			'<datalist id="pipetype"> <option value="in"><option value="out"></datalist></td>'+
			'<td><input name="dcpipe['+a+'].pipeShape" class="" value="" placeholder="待输入"/></td>'+
			'<td><div class="pipetype-table" style="width:100%"><div style="width:45%"><input name="dcpipe['+a+'].pipeSizec" class="" value="" placeholder="长或半径"/></div>'+
			'<div class="pipetype-table-x">X</div><div style="width:45%"><input name="dcpipe['+a+'].pipeSizek" class="" value="" placeholder="宽"/></div></div></td>'+
			'<td><input name="dcpipe['+a+'].backDrop" class="" value="" placeholder="待输入"/></td>'+
			'<td><input name="dcpipe['+a+'].pipeMaterial" class="" value="" placeholder="待输入"/></td>'+
			'<td><input name="dcpipe['+a+'].lining" class="" value="" placeholder="待输入"/></td>'+
			'<td><input name="dcpipe['+a+'].pipeDepth" class="" value="" placeholder="待输入"/></td>'+
			'<td><input name="dcpipe['+a+'].invert" class="" value="0"/></td>'+
			'<td><input name="dcpipe['+a+'].photo" class="" value="" placeholder="待输入"/></td>'+
			'<td><input name="dcpipe['+a+'].wallNo" class="" value="--"/></td>'+
			'<td><input name="dcpipe['+a+'].location" class="" value="--"/></td>'+
			'<td><label onclick="javascript:return delpipebyone(0)" class="label node-del-btn"><span class="glyphicon glyphicon-remove"></span> 删除</label></td>'+
			'</tr>';
	$('#pipe-table').find('tbody').append(tr);
});
//删除管道事件
$('.deletepipe').on('click',function(){
	var val=$('#pipe-table').find('tbody tr:last').find('td:last').text();
	console.log("内容"+val)
	$('#pipe-table').find('tbody tr:last').remove();
});

function delpipebyone(data){
	var tab = document.getElementById("pipe-table");
	var activeObj = event.srcElement;
	var rowIndex = activeObj.parentElement.parentElement.rowIndex;
	var pipeID=$('#delpipe').attr('value');
	if(confirm('确定要删除吗')==true){
		if(data=='0'){
			tab.deleteRow(rowIndex);
		}
		else{
			if(pipeID!='' && pipeID!=null){
				if(pipeID.indexOf(data)==-1){
					$('#delpipe').val(pipeID+','+data);
					activeObj.parentElement.parentElement.style.opacity="0.4";
				}
				else ;
			}
			else{
				$('#delpipe').val(data);
				activeObj.parentElement.parentElement.style.opacity="0.4";
			}
		}
		return true;
	}
	else{
		return false;
	}
	console.log("删除的pipeId为"+$('#delpipe').attr('value'))
}
function alertCheck(errorMess){
	$('.alert-danger').css('display', 'block');
	$('.error-mess').text(errorMess);
}
function check() {
	console.log("开始进入了");
	$('.alert-danger').css('display', 'none');
	var isRight = 1;
	$('.form-control').each(function(index) {
		var css = $(this).attr("class");
		// 如果在这些input框中，判断是否能够为空
		if ($(this).val() == "" && css.indexOf("nocheck")==-1) {
			// 获取到input框的兄弟的文本信息，并对应提醒；
			var brother = $(this).siblings('.control-label').text();
			var errorMess = "[" + brother + "输入框信息不能为空]";
			// 对齐设置错误信息提醒；红色边框
			$(this).parent().addClass("has-error has-feedback");
			$('.alert-danger').css('display', 'block');
			// 提示框的错误信息显示
			$('.error-mess').text(errorMess);
			// 模态框的错误信息显示
			$('.modal-error-mess').text(errorMess);
			isRight = 0;
			return false;
		} else {
			if(index == 0){
				 var flag =$(".onlynodeno").val();
				if(flag=="false"){
					$(this).parent().addClass("has-error has-feedback");
 					alertCheck("该井编号已存在");
 					isRight=0;
 					return false;
				}
			}
			return true;
		}
	});
	if (isRight == 0) {
		 return false;
	} else if (isRight == 1) {
		 return true;
	}
}