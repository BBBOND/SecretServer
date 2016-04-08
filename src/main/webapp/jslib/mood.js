/**
 * Created by 陈莹 on 2016/4/5.
 */
$(function () {
    $('#container').highcharts({
        credits: {
            enabled: false
        },
        title: {
            text: '用户心情排行',
            x: -20 //center
        },
        /*subtitle: {
            text: '',
            x: -20
        },*/
        xAxis: {
            title:{
                text : '心情值'
            },
            categories: ['0', '10', '20', '30', '40', '50', '60', '70', '80', '90', '100']
        },
        yAxis: {
            title: {
                text: '人数'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '人'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '',
            data: [7, 6, 9, 14, 18, 30, 2, 2, 23, 18, 13]
        }]
    });
});
