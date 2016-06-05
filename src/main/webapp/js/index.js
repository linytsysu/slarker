var jsondata = {};
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
		$.ajax({
			type: "GET",
			url: "/get_movie_scene",
			data: {},
			dataType: "json",
			success:function(data){
			        	decodeJson(data);
			        	list1.innerHTML = "";
			        	list2.innerHTML = "";
			        	list3.innerHTML = "";
			        	createItem();
					},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				list1.innerHTML = "";
				list2.innerHTML = "";
			    list3.innerHTML = "";
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

function createList3Element(obj){
	list3element = document.createElement('div');
	list3element.className = "ui segment";

	var big_span_1 = document.createElement('span');
	big_span_1.className = "list_bigspan";
	var span1_1 = document.createElement('span');
	span1_1.className = "list_item_top";
	var myDate = new Date(obj.beginDate);
	var hour = myDate.getHours();
	var min = myDate.getMinutes();
	var strhour;
	var strmin;
	if(hour < 10){
		strhour = "0" + hour;
	}else{
		strhour = "" + hour;
	}
	if(min < 10){
		strmin = "0" + min;
	}else{
		strmin = "" + min;
	}
	span1_1.innerHTML = strhour+":"+strmin;
	big_span_1.appendChild(span1_1);
	var span2_1 = document.createElement('span');
	span2_1.className = "list_item_bottom";
	span2_1.innerHTML = obj.duration;
	big_span_1.appendChild(span2_1);
	list3element.appendChild(big_span_1);

	var big_span_2 = document.createElement('span');
	big_span_2.className = "list_bigspan";
	var span1_2 = document.createElement('span');
	span1_2.className = "list_item_top";
	span1_2.innerHTML = obj.language;
	big_span_2.appendChild(span1_2);
	var span2_2 = document.createElement('span');
	span2_2.className = "list_item_bottom";
	span2_2.innerHTML = obj.version;
	big_span_2.appendChild(span2_2);
	list3element.appendChild(big_span_2);

	var big_span_3 = document.createElement('span');
	big_span_3.className = "list_bigspan";
	var span1_3 = document.createElement('span');
	span1_3.className = "list_item_middle";
	span1_3.innerHTML = obj.hallName;
	big_span_3.appendChild(span1_3);
	list3element.appendChild(big_span_3);

	var big_span_4 = document.createElement('span');
	big_span_4.className = "list_bigspan";
	var span1_4 = document.createElement('span');
	span1_4.className = "list_item_top";
	span1_4.innerHTML = obj.nowPrice;
	big_span_4.appendChild(span1_4);
	var span2_4 = document.createElement('span');
	span2_4.className = "list_item_bottom";
	var ss = document.createElement('s');
	ss.innerHTML = obj.originPrice;
	span2_4.appendChild(ss);
	big_span_4.appendChild(span2_4);
	list3element.appendChild(big_span_4);

	var big_span_5 = document.createElement('span');
	big_span_5.className = "list_bigspan";
	var span1_5 = document.createElement('span');
	span1_5.className = "list_item_middle";
	span1_5.innerHTML = "直降" + parseInt(obj.benefit) + "元";
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

function decodeJson(data){
	console.log(data);
	for(var obj in data){
		jsondata[obj] = {};
		for(var mov in data[obj]){
			var town = data[obj][mov]["videoHall"]["cinema"]["region"]["town"];
			var cinemaName = data[obj][mov]["videoHall"]["cinema"]["cinemaName"];
			if(jsondata[obj][town] == undefined){
				jsondata[obj][town] = {};
			}
			if(jsondata[obj][town][cinemaName]==undefined){
				jsondata[obj][town][cinemaName] = [];
			}
			var beginDate = data[obj][mov]["beginDate"];
			var language = data[obj][mov]["movie"]["country"];
			var duration = data[obj][mov]["movie"]["duration"];
			var version = data[obj][mov]["movie"]["version"][0];
			var originPrice = data[obj][mov]["price"];
			var nowPrice = originPrice*0.8;
			var benefit = originPrice - nowPrice;
			var hallName = data[obj][mov]["videoHall"]["voideHallName"];
			var video = {"beginDate":beginDate,"language":language,"benefit":benefit,
						"duration":duration,"version":version,"originPrice":
						originPrice,"nowPrice":nowPrice,"hallName":hallName	};
			jsondata[obj][town][cinemaName].push(video);
		}
	}
	console.log(jsondata);
}

function createItem(){
	var index = 0;
	for(var date in jsondata){
		//填充按钮日期
		var myDate = new Date(date);
		var month = myDate.getMonth();
		var day = myDate.getDate();
		var week = myDate.getDay();
		calendarButtonArray[index].innerHTML = month + "月" + day + "日" + "周" + week;
		calendarButtonArray[index].date = date;
		calendarButtonArray[index].onclick = function(){
			var i = index;
			return function(){
				console.log(i);
				//清空
				list1.innerHTML = "";
				list2.innerHTML = "";
				list3.innerHTML = "";
				//list1的内容填充
				for(var obj in jsondata[calendarButtonArray[i].date]){
					createList1Element(obj);
					//list2的内容填充
					list1element.onclick = function(){
						var region = obj;
						return function(){
							for(var obj2 in jsondata[calendarButtonArray[i].date][region]){
								createList2Element(obj2);
								list2element.onclick = function(){
									var address = obj2;
									return function(){
										for(var obj3 in jsondata[calendarButtonArray[i].date][region][address]){
											console.log(obj3);
											createList3Element(jsondata[calendarButtonArray[i].date][region][address][obj3]);
											list3.appendChild(list3element);
										}
									};
								}();
								list2.appendChild(list2element);
							}
							console.log(jsondata[calendarButtonArray[i].date][region]);
						};
					}();
					list1.appendChild(list1element);
				}
			};
		}();
		index++;
	}
}