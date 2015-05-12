/**
 * Created by Administrator on 2014/12/1.
 */
document.write(
    "<script src='js/html5shiv.js'></script>" +
    "<script src='js/respond.min.js'></script> " +
    "<script src='js/jquery.min.js'></script> " +
    "<script src='js/flat-ui.min.js'></script>" +
    "<script src='js/application.js'></script>"
);
function checksubmit(formid,str){
    if (confirm(str)) {
        return checkempty(formid);
    } else {
        return false;
    }
}
function checkempty(formid){
	var form = document.getElementById(formid);
	var a = form.elements.length;//所有的控件个数
	for (var j=0;j<a;j++){
		if(form.elements[j].className == "form-control"){//class="form-control"的控件
			if(form.elements[j].value=="" || form.elements[j].value==null){
				form.elements[j].focus();
				alert(form.elements[j].placeholder);
				return false;
			}
		}
	}
	return true;
}