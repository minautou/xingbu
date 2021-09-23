window.onload = function () {
    $(document).ready(function () {
        var ue = UE.getEditor('container', {
            //这里可以选择自己需要的工具按钮名称,
            toolbars: [[
                'source', //源代码
                'anchor', //锚点
                'undo', //撤销
                'redo', //重做
                'bold', //加粗
                'indent', //首行缩进
                'italic', //斜体
                'underline', //下划线
                'strikethrough', //删除线
                'subscript', //下标
                'fontborder', //字符边框
                'superscript', //上标
                'formatmatch', //格式刷

                'blockquote', //引用
                'pasteplain', //纯文本粘贴模式
                'selectall', //全选
                'print', //打印
                'preview', //预览
                'horizontal', //分隔线
                'removeformat', //清除格式
                'time', //时间
                'date', //日期
                'unlink', //取消链接
                'insertrow', //前插入行
                'insertcol', //前插入列
                'mergeright', //右合并单元格
                'mergedown', //下合并单元格
                'deleterow', //删除行
                'deletecol', //删除列
                'splittorows', //拆分成行
                'splittocols', //拆分成列
                'splittocells', //完全拆分单元格
                'deletecaption', //删除表格标题
                'inserttitle', //插入标题
                'mergecells', //合并多个单元格
                'deletetable', //删除表格
                'cleardoc', //清空文档
                'insertparagraphbeforetable', //"表格前插入行"
                'insertcode', //代码语言
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                // 'simpleupload', //单图上传
                // 'insertimage', //多图上传
                'edittable', //表格属性
                'edittd', //单元格属性
                'link', //超链接
                'emotion', //表情
                'spechars', //特殊字符
                'searchreplace', //查询替换
                'map', //Baidu地图
                'gmap', //Google地图
                'insertvideo', //视频
                'help', //帮助
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'backcolor', //背景色
                'insertorderedlist', //有序列表
                'insertunorderedlist', //无序列表
                'fullscreen', //全屏
                'directionalityltr', //从左向右输入
                'directionalityrtl', //从右向左输入
                'rowspacingtop', //段前距
                'rowspacingbottom', //段后距
                'pagebreak', //分页
                'insertframe', //插入Iframe
                'imagenone', //默认
                'imageleft', //左浮动
                'imageright', //右浮动
                'attachment', //附件
                'imagecenter', //居中
                'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
                'customstyle', //自定义标题
                'autotypeset', //自动排版
                'webapp', //百度应用
                'touppercase', //字母大写
                'tolowercase', //字母小写
                'background', //背景
                'template', //模板
                'scrawl', //涂鸦
                'inserttable', //插入表格
                'drafts', // 从草稿箱加载
                'charts', // 图表
            ]],
            //focus时自动清空初始化时的内容
            autoClearinitialContent:true,
            //关闭字数统计
            wordCount:false,
            //关闭elementPath
            elementPathEnabled:false,
            //图片本地化
            emotionLocalization:true,
            //关闭本地自动保存
            autosave:false,
            //默认的编辑区域高度
            initialFrameHeight:300,
            // 设置成true，div标签会自动转换成p标签
            allowDivTransToP: false ,
            //更多其他参数，请参考ueditor.config.js中的配置项
        });

        $(".tou-qu").on("click", function () { // 取消按钮
            $(".toug").hide();
            $("#texts").val("");
            $("#image_box").find(".img-wrap").remove();
            $("#vjs_video").remove();
        });

        UE.getEditor("container").addListener('blur',function(editor){$("#subok").html(UE.getEditor("editor").getAllHtml())});// 失去焦点事件
        $("#form1").submit(function (){
            var contextPath=$("#contextPath").val();
            $.ajax({
                type: "post",
                dataType: "html",
                url: contextPath+'/index.do',
                data: $('#form1').serializeArray(),
                success: function (data) {
                    alert("提交成功>>>");
                },
                error: function(data) {
                    alert("error:提交失败");
                }
            })
        });
    });
}