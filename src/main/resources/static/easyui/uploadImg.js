 function UploadImg(cfg) {
   if (!cfg.container) {
     throw new Error('必须使用一个容器');
     return;
   }
   this.container = cfg.container;
   this.width = 1506;
   this.isfold = true;
   //后台传来的地址值
   this.imgpath='';
   //删除的图片地址
   this.deletepath='';
   //是否显示图片按钮
   this.isShow=false;
   // 上传url 
   this.url = '';
   // data 数据 页面默认显示图片的数据
   this.data =  [];
   // 上传文件到服务器端fileName字段 默认为 imgFile, 也可以根据服务器端需要什么字段 自己自定义
   this.fileName = 'imgFile'; 
   // 上传文件保存后数组
   this.fileFilter = [];
   // 文件被删除后的方法
   this.onDelete = function(){};
   // 文件离开到敏感区域时
   this.onDragLeave = this.isDragDrop ? cfg.onDragLeave : function(){};
   //初始化
   this.init();
   // 绑定事件
   this.bindEnv();
 }
 UploadImg.prototype = {
    init: function() {
      var self = this;
      var inputDOM = $(this.container).html();
      var containerId = $(this.container).attr('id');
      this.containerId = containerId;
      var html =  '<div class="upload-inner" style="width:'+this.width+'px">' + 
                    '<div class="upload_choose">' + 
                      '<div id="form_'+containerId+'"></div>' +
                    '</div>' + 
                    '<div class="upload_main">' + 
                      '<div id="file_'+containerId+'"></div>'+
                      '<div class="showimg upload_preview none" id="have_img">' + 
                      	'<ul id="have_'+containerId+'" name="testclass"></ul>'+
                      '</div>' +
                      '<div class="previewimg upload_preview none">' + 
                        '<ul id="preview_'+containerId+'"></ul>' + 
                      '</div>' +
                      '<div class="delete_submit none">' + 
                        '<span href="javascript:void(0)" class="delete_submit_btn"> 一键删除  </span>' + 
                      '</div>' +
                    '</div>' +
                '</div>';
      $(this.container).html(html);
      $("#form_"+containerId).html(inputDOM);
      // 如果需要折叠按钮的话
      if (this.isfold) {
        $(this.container).find('.upload-inner').prepend("<span class='foldbtn'></span>");
      }
    },
    bindEnv: function() {
      var self = this;
      var data = this.data;
      // 文件选择事件 
      var fileInput = $("#form_"+this.containerId + ' input[type="file"]')[0];
      fileInput.addEventListener('change', function(e) {
        self.funGetFiles(e);
      }, false);
      // 折叠操作
      if (this.isfold) {
        var foldbtn = $(this.container).find('.foldbtn')[0];
        foldbtn.addEventListener('click', function(e) {
          self.foldDiv(e);
        }, false);
      }
      // 删除操作
      $(this.container).on('click', '.upload_delete', function() {
        self.deleteFile(parseInt($(this).attr('data-index')));
      });
      //一键删除
      $(this.container).on('click', '.delete_submit_btn', function() {
    	   var filelength = self.fileFilter.length;
    	   for(var a=0;a<filelength;a++){
    		   self.deleteFile(parseInt(a));
    	   }
        });
      
      this.imgpath=$(this.container).find('.imgpath').val();
      if(this.imgpath!=''&&this.imgpath!='null'){
    	  console.log("imgpath:"+this.imgpath);
    	  var imgpathlist=this.imgpath.split(",");
    	  self.showImage(imgpathlist);
    	  $(self.container).find('#have_img').removeClass('none');
      }
      
      $(this.container).on('click', '#xiugai', function() {
    	  var theclass = $('#have_'+self.containerId).find('.img_delete').attr("class");
    	  console.log("img_delete的class为"+theclass);
    	  var sub = "none";
    	  if(theclass.indexOf(sub) == -1){
    		  console.log("没有none");
    		  $('#have_'+self.containerId).find('.img_delete').addClass('none');
    	  }
    	  else{
    		  console.log("有none");
    	  $('#have_'+self.containerId).find('.img_delete').removeClass('none');
    	  }
    	  });
      
      $(this.container).on('click','.img_delete',function(){
    	  var path=$(this).attr('date-index');
    	  var value=$("#form_"+self.containerId).find('.deletepath').val();
    	  console.log("匹配结果"+value.indexOf(path));
    	  if(value!=null && value!=''){
    		  if(value.indexOf(path) == -1){
    			  $("#form_"+self.containerId).find('.deletepath').val(value+','+path);
    		  }
    		  else;
    	  }
    	  else{
    		  $("#form_"+self.containerId).find('.deletepath').val(value+path);
    	  }
    	  $(this).parent().parent().css("opacity","0.4");
    	  var value2=$("#form_"+self.containerId).find('.deletepath').val();
    	  console.log('.deletepath的value值为'+value2);
      });
    },
    funGetFiles: function(e) {
        // 获取被选择的文件对象列表
        var files = e.target.files || e.dataTransfer.files;
        // 继续添加文件 调用filter方法
        var files = this.filter(files);
        this.fileFilter = this.fileFilter.concat(files); 
        // 选择文件的处理
        this.dealFiles();
        return this;
      },
      // 选择文件的处理
      dealFiles: function() {
        var files = this.fileFilter;
        if (files.length) {
          for(var i = 0, ilen = files.length; i < ilen; i++) {
            // 索引值
            this.fileFilter[i].index = i;
          }
          // 执行选择回调
          this.onSelect(this.fileFilter);
          return this;
        }
      },
    // 选择文件组的过滤方法 返回所有过滤后的文件
    filter: function(files) {
      var arrFiles = [];
      for (var i = 0, file; file = files[i]; i++) {
        if (file.size >= 1024000) {
          alert('您这张'+ file.name + '图片过大，应小于1M');
        } else {
          arrFiles.push(file);
        }
      }
      return arrFiles;
    },
    // 折叠操作
    foldDiv: function(e) {
      var target = e.target;
      if (!$(target).hasClass("up")) {
        $(target).addClass('up');
        $(this.container).find('.upload_main').slideUp();
      } else {
        $(target).removeClass('up');
        $(this.container).find('.upload_main').slideDown();
      }
    },
    onSelect: function(files) {
    	console.log("到选择方法了");
      var self = this;
      var html = '',
        i = 0;
      var funAppendImage = function() {
        var file = files[i];
        if (file) {
          var reader = new FileReader();
          reader.onload = function(e) {
            var progressCls = file.successStatus ? 'upload-progress success' : 'upload-progress';
            var loaderCls  =  file.successStatus ? 'ajax-loader hidden' : (file.failStatus ?  'ajax-loader upload-fail': 'ajax-loader hidden');
            html += '<li id="uploadList_'+ i +'" class="upload_append_list">'+
                      '<div class="m-layer none" id="m-layer_'+self.containerId+i+'"></div>' + 
                      '<span class="'+loaderCls+'" id="loader_'+self.containerId+i+'"></span>'+
                      '<p>'+
                        '<span href="javascript:void(0)" class="upload_delete" title="删除" data-index="'+ i +'"></span>' +
                        '<i class="'+progressCls+'"></i>' + 
                        '<em>' +  
                          '<img id="uploadImage_' + i + '" src="' + e.target.result + '" class="upload_image" />'+
                        '</em>' + 
                      '</p>'+ 
                      '<a class="filename" title="'+file.name+'">' + file.name + '</a>'+
                    '</li>';
            i++;
            funAppendImage();
          }
          reader.readAsDataURL(file);
        }else {
          $("#preview_"+self.containerId).html(html);
          self.listCls();
        }
      };
      funAppendImage();
    },
    //显示数据库图片
    showImage:function(imgpaths){
    	var self = this;
    	let html = '';
    	console.log("数组长度为"+imgpaths.length);
    	for(let i=0;i<imgpaths.length;i++){
    		console.log("进来了"+i+"与"+imgpaths[i]);
    		html +='<li id="'+i+'" class="upload_append_list">'+
			'<p><span href="javascript:void(0)" class="img_delete none" id="img_delete" title="删除" date-index="'+imgpaths[i]+'"></span>'+
			'<em><img id="showimg_'+i+'" src="/image/'+imgpaths[i]+'" class="upload_image"/></em></p></li>';
    	}
      	var name=$('#have_'+self.containerId).attr("name");
    	console.log("该元素name为"+name+"containerId:"+self.containerId);
    	$("#have_"+self.containerId).html(html);
    },
    deleteFile: function(index){
      $("#form_"+this.containerId + ' input[type="file"]').eq(0).val('');
      $(this.container + " #uploadList_" + index).eq(0).fadeOut();
      this.resetSetValue(index);
      this.listCls();
      this.onDelete(index);
      return this;
    },
    listCls: function() {
        if (this.fileFilter.length > 0) {
          $(this.container).find('.previewimg').removeClass('none');
          $(this.container).find('.delete_submit').removeClass('none');
        } else {
        	$(this.container).find('.previewimg').addClass('none');
            $(this.container).find('.delete_submit').addClass('none');
        }
      },
    resetSetValue: function(index) {
      var index = this.indexOf(index, this.fileFilter);
      if (index !== -1) {
        this.fileFilter.splice(index, 1);
      }
    },
    indexOf: function(index, arrs){
        if (arrs.length) {
          for (var i = 0, ilen = arrs.length; i < ilen; i++) {
            if (arrs[i].index == index) {
              return i; 
            }
          }
        }
        return -1;
     }
 };
 window.UploadImg = UploadImg;
