<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'visualrecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1 align = "center">数据视图</h1>
    <hr>
    
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:800px"></div>
    
    
    <!-- ECharts单文件引入 -->
    <script src="./js/jq/jquery-1.9.0-min.js"></script>
    <script src="./js/dist/echarts.js"></script>
    <script type="text/javascript">
        require.config({
            paths: {
                echarts: './js/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/k' // 按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                
                //参考网页上的实例
                var option = {
                	    tooltip : {
                	        trigger: 'axis',
                	        formatter: function (params) {
                	            var res = params[0].seriesName + ' ' + params[0].name;
                	            res += '<br/>  月初 : ' + params[0].value[0] + '  最高 : ' + params[0].value[3];
                	            res += '<br/>  月末 : ' + params[0].value[1] + '  最低 : ' + params[0].value[2];
                	            return res;
                	        }
                	    },
                	    legend: {
                	        data:['月报']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataZoom : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    dataZoom : {
                	        show : true,
                	        realtime: true,
                	        start : 0,
                	        end : 100
                	    },
                	    xAxis : [
                	        {
                	            type : 'category',
                	            boundaryGap : true,
                	            axisTick: {onGap:false},
                	            splitLine: {show:false},
                	            data : [
                	                 //"2013/1/25", "2013/1/28", "2013/1/29",
                	            ]
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value',
                	            scale:true,
                	            boundaryGap: [0.01, 0.01]
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'我的资产',
                	            type:'k',
                	            barMaxWidth: 20,
                	            itemStyle: {
                	                normal: {
                	                    color: 'red',           // 阳线填充颜色
                	                    color0: 'lightgreen',   // 阴线填充颜色
                	                    lineStyle: {
                	                        width: 2,
                	                        color: 'orange',    // 阳线边框颜色
                	                        color0: 'green'     // 阴线边框颜色
                	                    }
                	                },
                	                emphasis: {
                	                    color: 'black',         // 阳线填充颜色
                	                    color0: 'white'         // 阴线填充颜色
                	                }
                	            },
                	            data:[ // 开盘，收盘，最低，最高

                	                //[2300,2291.3,2288.26,2308.38],
                	                //[2295.35,2346.5,2295.35,2346.92],
                	                //[2347.22,2358.98,2337.35,2363.8],
             
                	            ],
                	            
                	        }
                	    ]
                	};


                	                    


                	//加载数据,我们自己定义
                    loadDATA(option);   
                	
                	//为EChart对象加载数据
                	myChart.setOption(option);
                	
                	// 图表清空-------------------
                	//myChart.clear();

                	// 图表释放-------------------
                	//myChart.dispose();
            }    	                    
        );
        
        function loadDATA(option){
        	$.ajax({
                type : "post",
                async : false, //同步执行
                url : "./servlet/Controller?op=loadDataForKchart",
                data : {},
                dataType : "json", //返回数据形式为json
                success : function(result) {
                   if (result) {
                 	  option.xAxis[0].data=[];
                 	  option.xAxis[0].data=result[0];
                 	  option.series[0].data=[];
                      option.series[0].data=result[1];
                       }
                    }
            
             });
       }
        
        

    </script>
  </body>
</html>
