layui.use(['element','jquery'], function(){
    var element = layui.element;
    var $ = layui.jquery;

    $(function () {
        //页面加载时显示部门表模块
        $('#contentData').attr('src','emps.html');
    })

    //监听导航点击
    element.on('nav(test)', function(elem){
        console.log(elem.text())

        if(elem.text()=="员工表"){
            //显示员工表模块
            $('#contentData').attr('src','emps.html');
        }else{
            //显示部门表模块
            $('#contentData').attr('src','depts.html');
        }

    });
});