/**
 *  ajax.js
 */

const xhtp = new XMLHttpRequest();
xhtp.open('get','boardList.do');
xhtp.send();
xhtp.onload = function(){
	//화면출력.

}
 