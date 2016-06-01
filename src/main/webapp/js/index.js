window.onload=function(){
	$('#selectdrop').dropdown();
	var sidebar = document.getElementById('sideBar');
	var mask = document.getElementById('mask');
	document.getElementById('sideBarButton').onclick=function(){
		sidebar.style.right = "0px";
		mask.style.display = "block";
	};
	var backbutton = document.getElementById('backButton');
	backbutton.onclick = function(){
		sidebar.style.right = "-1200px";
		mask.style.display = "none";
	};
}