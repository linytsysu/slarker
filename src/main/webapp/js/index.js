var jsondata;
//jsondata["key"]
var calendarButtonArray;
//index:0-6
var list1;
var list2;
var list3;
//list1,list2,list3
var list1element;
var list2element;
var list3element;

window.onload=function(){
	$('#selectdrop').dropdown();
	var sidebar = document.getElementById('sideBar');
	var mask = document.getElementById('mask');
	//选座购票按钮的点击事件
	document.getElementById('sideBarButton').onclick=function(){
		sidebar.style.right = "0px";
		mask.style.display = "block";
		console.log("123");
		$.ajax({
			type: "GET",
			url: "/get_movie_scene",
			data: {},
			dataType: "json",
			success:function(data){
			        	console.log(data);
			        	list1.innerHTML = "";
			        	list2.innerHTML = "";
			        	list3.innerHTML = "";
					},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//list1.innerHTML = "";
				//list2.innerHTML = "";
			    //list3.innerHTML = "";
				createList1Element("123地区");
				createList2Element("广州白云万达影城");
				createList3Element("静态");
				list1.appendChild(list1element);
				list2.appendChild(list2element);
				list3.appendChild(list3element);
				console.log(XMLHttpRequest.status);
				console.log(XMLHttpRequest.readyState);
				console.log(textStatus);
			}
		});
	};
	//返回按钮的触发事件
	var backbutton = document.getElementById('backButton');
	backbutton.onclick = function(){
		sidebar.style.right = "-1200px";
		mask.style.display = "none";
	};
	calendarButtonArray = document.getElementById('calendarButton').getElementsByTagName("button");
	list1 = document.getElementById('list1');
	list2 = document.getElementById('list2');
	list3 = document.getElementById('list3');
}


function createList1Element(text){
	list1element = document.createElement('div');
	list1element.className = "ui segment";
	//list1element.setAttribute("class", "ui segment");
	var p = document.createElement('p');
	p.innerHTML = text;
	list1element.appendChild(p);
}

//和list1一样
function createList2Element(text){
	list2element = document.createElement('div');
	list2element.className = "ui segment";
	//list1element.setAttribute("class", "ui segment");
	var p = document.createElement('p');
	p.innerHTML = text;
	list2element.appendChild(p);
}

function createList3Element(text){
	list3element = document.createElement('div');
	list3element.className = "ui segment";

	var big_span_1 = document.createElement('span');
	big_span_1.className = "list_bigspan";
	var span1_1 = document.createElement('span');
	span1_1.className = "list_item_top";
	span1_1.innerHTML = "11:20";
	big_span_1.appendChild(span1_1);
	var span2_1 = document.createElement('span');
	span2_1.className = "list_item_bottom";
	span2_1.innerHTML = "12:57散场";
	big_span_1.appendChild(span2_1);
	list3element.appendChild(big_span_1);

	var big_span_2 = document.createElement('span');
	big_span_2.className = "list_bigspan";
	var span1_2 = document.createElement('span');
	span1_2.className = "list_item_top";
	span1_2.innerHTML = "英语";
	big_span_2.appendChild(span1_2);
	var span2_2 = document.createElement('span');
	span2_2.className = "list_item_bottom";
	span2_2.innerHTML = "4D";
	big_span_2.appendChild(span2_2);
	list3element.appendChild(big_span_2);

	var big_span_3 = document.createElement('span');
	big_span_3.className = "list_bigspan";
	var span1_3 = document.createElement('span');
	span1_3.className = "list_item_middle";
	span1_3.innerHTML = "一号MX4D厅";
	big_span_3.appendChild(span1_3);
	list3element.appendChild(big_span_3);

	var big_span_4 = document.createElement('span');
	big_span_4.className = "list_bigspan";
	var span1_4 = document.createElement('span');
	span1_4.className = "list_item_top";
	span1_4.innerHTML = "65";
	big_span_4.appendChild(span1_4);
	var span2_4 = document.createElement('span');
	span2_4.className = "list_item_bottom";
	var ss = document.createElement('s');
	ss.innerHTML = "85";
	span2_4.appendChild(ss);
	big_span_4.appendChild(span2_4);
	list3element.appendChild(big_span_4);

	var big_span_5 = document.createElement('span');
	big_span_5.className = "list_bigspan";
	var span1_5 = document.createElement('span');
	span1_5.className = "list_item_middle";
	span1_5.innerHTML = "直降10元";
	big_span_5.appendChild(span1_5);
	list3element.appendChild(big_span_5);

	var big_span_6 = document.createElement('span');
	big_span_6.className = "list_bigspan";
	var button1_6 = document.createElement('button');
	button1_6.className = "ui orange button";
	button1_6.innerHTML = "选座购票";
	big_span_6.appendChild(button1_6);
	list3element.appendChild(big_span_6);
}