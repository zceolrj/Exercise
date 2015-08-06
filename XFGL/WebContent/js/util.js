/**
 * 得到中英文字符长（中文为2个字符）
 */
function getStrLength(str){
	var p1 = new RegExp('%u..', 'g');
	var p2 = new RegExp('%', 'g');
	return escape(str).replace(p1, '').replace(p2, '').length;
}

/** 
 * 检查str是否为数字（由数字组成） 
 * 
 */  
function isNum(str) {  
    var re = /^[\d]+$/;  
    return re.test(str);  
}

/**
 * 带区号的电话   xxx-xxxxxxxx
 * 区号位数3-4位  
 * 固定电话7-8位
 */
function isTel(str){
	var re = /^\d{3,4}-\d{7,8}$/;
	return re.test(str);
}

















