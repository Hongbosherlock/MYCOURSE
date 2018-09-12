function getManager_Data(obj){
			setActive(obj);
    		var frameInner = document.getElementById('external-frame'); 
    		frameInner.src="Manager_Data.html";
    	}

function getManager_DataCheck(obj){
			setActive(obj);
    		var frameInner = document.getElementById('external-frame'); 
    		frameInner.src="Manager_DataCheck.html";
    	}
function setActive(obj){
	var list = document.getElementsByClassName("active-menu");
	var i;
	for(i = 0;i<list.length;i++){
		list[i].setAttribute("class","");
	}
	obj.setAttribute("class","active-menu");
}
