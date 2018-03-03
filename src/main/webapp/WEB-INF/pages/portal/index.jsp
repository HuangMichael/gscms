<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<% response.setContentType("text/html;charset=UTF-8");%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<%@include file="../common/common-head.jsp" %>
<body>
<!-- HEADER -->
<%@include file="../common/common-navbar.jsp" %>
<!--/HEADER -->
<!-- PAGE -->
<section id="page">
    <!-- SIDEBAR -->
    <%@include file="../common/common-siderbar.jsp" %>
    <!-- /SIDEBAR -->
    <div id="main-content">
        <div class="container">
            <div class="row">
                <div id="content" class="col-lg-12">
                    <!-- PAGE HEADER-->
                    <%@include file="../common/common-breadcrumb.jsp" %>

                    <div class="row">
                        <div class="col-md-6">
                            <div id="chart0" style="height:350px;width: 100%"></div>
                        </div>
                        <div class="col-md-6">
                            <div id="chart1" style="height:350px;width: 100%"></div>
                        </div>
                        <div class="col-md-6">
                            <div id="chart2" style="height:350px;width: 100%"></div>
                        </div>

                        <div class="col-md-6">
                            <div id="chart3" style="height:350px;width: 100%"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../common/common-foot.jsp" %>

<script src="/js/app/portal/portal.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript">
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart0 = ec.init(document.getElementById('chart0'));
            var myChart1 = ec.init(document.getElementById('chart1'));
            var myChart2 = ec.init(document.getElementById('chart2'));
            var myChart3 = ec.init(document.getElementById('chart3'));

            var option = {
                title: {
                    text: '网站访问量统计',
                    subtext: '纯属虚构'
                },
                tooltip: {
                    show: true
                },
                legend: {
                    data: ['访问量']
                },
                xAxis: [
                    {
                        type: 'category',
                        data: ["2018-02-01", "2018-02-02", "2018-02-03", "2018-02-04", "2018-02-05", "2018-02-06", "2018-02-07"]
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        "name": "访问量",
                        "type": "bar",
                        "data": [5, 20, 40, 10, 10, 20, 33]
                    }
                ]
            };


            var weatherIcons = {
                'Sunny': './data/asset/img/weather/sunny_128.png',
                'Cloudy': './data/asset/img/weather/cloudy_128.png',
                'Showers': './data/asset/img/weather/showers_128.png'
            };

            var option1 = {
                title: {
                    text: '网站访问量统计',
                    subtext: '虚构数据',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    // orient: 'vertical',
                    // top: 'middle',
                    bottom: 10,
                    left: 'center',
                    data: ['甘肃文联网', '作家协会', '书法家协会', '摄影家协会', '舞蹈家协会']
                },
                series: [
                    {
                        type: 'pie',
                        radius: '65%',
                        center: ['50%', '50%'],
                        selectedMode: 'single',
                        data: [
                            {
                                value: 1548,
                                name: '舞蹈家协会',
                                label: {
                                    normal: {
                                        formatter: [
                                            '{title|{b}}{abg|}',
                                            '  {weatherHead|天气}{valueHead|天数}{rateHead|占比}',
                                            '{hr|}',
                                            '  {Sunny|}{value|202}{rate|55.3%}',
                                            '  {Cloudy|}{value|142}{rate|38.9%}',
                                            '  {Showers|}{value|21}{rate|5.8%}'
                                        ].join('\n'),
                                        backgroundColor: '#eee',
                                        borderColor: '#777',
                                        borderWidth: 1,
                                        borderRadius: 4,
                                        rich: {
                                            title: {
                                                color: '#eee',
                                                align: 'center'
                                            },
                                            abg: {
                                                backgroundColor: '#333',
                                                width: '100%',
                                                align: 'right',
                                                height: 25,
                                                borderRadius: [4, 4, 0, 0]
                                            },
                                            Sunny: {
                                                height: 30,
                                                align: 'left',
                                                backgroundColor: {
                                                    image: weatherIcons.Sunny
                                                }
                                            },
                                            Cloudy: {
                                                height: 30,
                                                align: 'left',
                                                backgroundColor: {
                                                    image: weatherIcons.Cloudy
                                                }
                                            },
                                            Showers: {
                                                height: 30,
                                                align: 'left',
                                                backgroundColor: {
                                                    image: weatherIcons.Showers
                                                }
                                            },
                                            weatherHead: {
                                                color: '#333',
                                                height: 24,
                                                align: 'left'
                                            },
                                            hr: {
                                                borderColor: '#777',
                                                width: '100%',
                                                borderWidth: 0.5,
                                                height: 0
                                            },
                                            value: {
                                                width: 20,
                                                padding: [0, 20, 0, 30],
                                                align: 'left'
                                            },
                                            valueHead: {
                                                color: '#333',
                                                width: 20,
                                                padding: [0, 20, 0, 30],
                                                align: 'center'
                                            },
                                            rate: {
                                                width: 40,
                                                align: 'right',
                                                padding: [0, 10, 0, 0]
                                            },
                                            rateHead: {
                                                color: '#333',
                                                width: 40,
                                                align: 'center',
                                                padding: [0, 10, 0, 0]
                                            }
                                        }
                                    }
                                }
                            },
                            {value: 535, name: '摄影家协会'},
                            {value: 510, name: '书法家协会'},
                            {value: 634, name: '作家协会'},
                            {value: 735, name: '甘肃文联网'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };


            var option2 = {
                title: {
                    text: '网站栏目访问统计'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '邮件营销',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: [120, 132, 101, 134, 90, 230, 210]
                    },
                    {
                        name: '联盟广告',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: [220, 182, 191, 234, 290, 330, 310]
                    },
                    {
                        name: '视频广告',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: [150, 232, 201, 154, 190, 330, 410]
                    },
                    {
                        name: '直接访问',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: [320, 332, 301, 334, 390, 330, 320]
                    },
                    {
                        name: '搜索引擎',
                        type: 'line',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'top'
                            }
                        },
                        areaStyle: {normal: {}},
                        data: [820, 932, 901, 934, 1290, 1330, 1320]
                    }
                ]
            };


            var option3 = {
                title: {
                    text: '内容发布审核统计',
                    subtext: '纯属虚构'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['已申请', '已发布']
                },
                toolbox: {
                    show: false,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '已申请',
                        type: 'bar',
                        data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                    {
                        name: '已发布',
                        type: 'bar',
                        data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                        markPoint: {
                            data: [
                                {name: '年最高', value: 182.2, xAxis: 7, yAxis: 183, symbolSize: 18},
                                {name: '年最低', value: 2.3, xAxis: 11, yAxis: 3}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };


            // 为echarts对象加载数据
            myChart0.setOption(option);
            myChart1.setOption(option1);
            myChart2.setOption(option2);
            myChart3.setOption(option3);
        }
    );
</script>

</body>
</html>