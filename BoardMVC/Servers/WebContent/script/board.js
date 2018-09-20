function check() {
if(document.frm.title.value.length==0){
	alert('제목입력');
	return false;
	
}
if(document.frm.content.value.length==0){
	alert('냉ㅇ 입력');
	return false;
	
}
return true;

}