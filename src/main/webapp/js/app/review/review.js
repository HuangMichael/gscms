/**
* Created by huangbin on 2018-3-1 09:46:42.

*/


$(function () {


//å¯¼å‡ºå¿…é¡»é…ç½®çš„ä¸¤ä¸ªé‡
dataTableName = "#reviewListTable";
docName = "³õÉóÁĞ±í";
mainObject = "review";


initSelect();

var searchVue = new Vue({
el: "#searchBox"
});

searchModel = [
{"param": "name", "paramDesc": "å…³é”®å­?"}
];

initBootGrid(dataTableName);

$("#searchBtn").trigger("click");


});
