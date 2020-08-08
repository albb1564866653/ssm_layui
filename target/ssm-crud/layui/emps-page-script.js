layui.use([ 'element', 'jquery','form','layer','table','laydate'], function() {
    var $ = layui.jquery;
    var element = layui.element;
    var form = layui.form;
    var layer = layui.layer;
    var table = layui.table;
    var laydate = layui.laydate;

    //模拟登陆拦截器
    $(function () {
        $.post("admin/check",function (res) {
            if (res=="NULL"){
                location.href = 'login.html'; //后台主页
            }
        })
    })

    $('#logOut_btn').click(function () {

        layer.confirm('真的退出么', function(index){
            layer.msg('已退出', {
                offset: '15px'
                ,icon: 7
                ,time: 1000
            }, function(){
                //请求后端 销毁session
                $.get("admin/logout",function () {
                    location.href="login.html";
                })
            });


        });


    })

    //渲染表格数据
    var tableIns =table.render({
        elem: '#userTable'  //渲染的目标对象
        ,url:'admin/list'  //数据接口
        ,toolbar: '#userToolBar'    //开启表格头部工具栏区域
        ,defaultToolbar: ['filter','print']
        // ,height: 300
        // ,height: 'full-300'
        ,cellMinWidth: 100  //设置列的最小默认宽度
        ,done: function (res,curr,count) {
        }
        ,totalRow: true   //开启合并行
        ,title: '用户数据表' //数据导出的标题
        ,page: true //是否启用分页
        ,cols: [[ //列表数据
            {type: 'checkbox', fixed: 'left'}
            ,{field:'empId', title:'ID',sort: true}
            ,{field:'empName', title:'用户名',align: 'center'}

            ,{field:'gender', title:'性别',  templet: function (res) {
                    return res.gender=='M'?'男':'女';
                }}
            ,{field:'email', title:'邮箱',align: 'center' , templet: function(res){
                    return res.email
                }}
            ,{field:'dId', title:'部门编号',align: 'center'}
            ,{fixed: 'right', title:'操作', toolbar: '#userBar', width:220,align: 'center'}
        ]]


    })

    //监听头部工具栏事件
    table.on('toolbar(userTable)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                openAddPerson();
                break;
            case 'batchDelete':
                batchDeletion();
                break;
        };
    });

    //监听工具条
    table.on('tool(userTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        if(layEvent === 'del'){ //删除
            layer.confirm('真的删除【'+data.empName+'】么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);

                //向服务端发送删除指令
                $.post('admin/deleteEmp?empId='+data.empId,function (res) {
                    layer.msg(res.data);
                })
            });
        } else if(layEvent === 'edit'){ //编辑
            //do something
            openUpdatePerson(data);
        }
    });

    var url;
    var mainIndex;

    //打开添加页面
    function openAddPerson(){
        //去除员工编号只读限制
        $('#isReadonly').removeAttr('readonly')
        mainIndex=layer.open({
            type:1,
            title:'新增员工',
            content:$('#saveOrUpdateDiv'),
            area:['360px'],
            success:function (index) {
                //清空表单
                $('#dataFrm')[0].reset();
                //进入添加页面 把url赋值地址
                url="admin/addEmp";
            }
        })
    }

    //打开编辑页面
    function openUpdatePerson(data){
        $('#isReadonly').attr('readonly','readonly')
        mainIndex=layer.open({
            type:1,
            title:'编辑员工',
            content:$('#saveOrUpdateDiv'),
            area:['360px'],
            success:function (index) {
                form.val("dataFrm",data);
                //进入编辑页面 把url赋值地址
                url="admin/updateEmp";
            }
        })

    }

    //保存
    form.on("submit(submit)",function (obj) {
        //序列化表单数据
        var params=$("#dataFrm").serialize();

        //请求后端添加或编辑方法
        $.post(url,params,function (data) {
            layer.msg(data.data)
            //关闭弹出层
            layer.close(mainIndex)
            //刷新数据 表格
            tableIns.reload();
        })
    })

    //批量删除
    function batchDeletion(){

        var checkStatus = table.checkStatus('userTable'); //idTest 即为基础参数 id 对应的值

        console.log(checkStatus.data) //获取选中行的数据
        console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
        console.log(checkStatus.isAll ) //表格是否全选
        var empIds='';
        for(var i=0;i<checkStatus.data.length;i++){
            empIds+=checkStatus.data[i].empId+'-';
        }
        empIds=empIds.substring(0,empIds.lastIndexOf('-'));//处理id集合的最后一个-符号

        if(checkStatus.data.length>0){
            layer.confirm('真的删除所选员工么', function(index){

                layer.close(index);

                //向服务端发送删除指令
                $.post('admin/batchDeletion?empIds='+empIds,function (res) {
                    layer.msg(res.data);
                    tableIns.reload();
                })
            });
        }else{
            layer.msg('至少选择一个员工')
        }


    }

    //查询按钮
    form.on("submit(search)",function (obj) {
        layer.msg("查询")

    })


});