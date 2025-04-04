/**
 *  artay.js
 * 	push, unshift 추가.
 *  pop, shift 제거.
 *  splice 추가,수정,삭제
 *  forEach()  
 */

// 배열 생성.
const ary = [];
// push, unshift
ary.push('홍길동'); // 마지막 위치에 추가.
ary.push('김길동');
ary.unshift('최길동'); // 젤 앞위치에 추가.

// pop. shift 
//ary.pop(); // 마지막 위치에서 부터 삭제.
//ary.shift(); // 젤 앞위치에서 부터 삭제

// splice 추가, 수정, 삭제 다가능하다. 
//첫번째 매개값은 위치, 두번째 매개값은 크기(0을 넣으면 추가) ,세번째 매개값은 대채할값 (안넣으면 삭제) 
//ary.splice(0, 0, '박길동','황길동'); // 첫번째위치 , 크기, 대체값 

// forEach 메소드 함수를 매개값으로 가진다.
ary.forEach(function(item, idx, ary){
	console.log(`item=> ${item}, index=>${idx}, array=> ${ary}`);
});


// 함수.
function addElement(elem = "noElem"){
	ary.push(elem);
}

// 화면요소를 제거하는 메소드.
function deleteElement(e){
	//alert('삭제버튼 클릭됨');
	console.log(e.target.parentElement);
	e.target.parentElement.remove();
} 

// 추가버튼에 클릭이벤트.
document.querySelector('button#addBtn').addEventListener('click', function(){
	// input 값
	let val = document.querySelector('input#userInput').value;
	addElement(val); // ary배열에 추가.
	// 화면에 출력.
	let html = '';
	ary.forEach(function(item, idx, ary){
		html += '<li>' + item +'<button onclick="deleteElement(event)">삭제</button></li>';
	});
	// ul태그 영역.
	document.querySelector('ul#list').innerHTML = html ;
});
