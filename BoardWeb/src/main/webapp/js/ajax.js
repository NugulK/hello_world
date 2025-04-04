/**
 * ajax.js
 */
// 비동기방식으로 처리해주는 대표적인 방식
let dataAry;
const xhtp = new XMLHttpRequest();
xhtp.open('get','data/MOCK_DATA.json'); // 경로지정
xhtp.send();
xhtp.onload = function(){ // load이벤트 발생.
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	dataAry = obj; // 대입.
	//화면 출력.
	obj.forEach(function(item, idx, ary){
		let tr = makeRow(item);
		document.querySelector('tbody#target').appendChild(tr);
	})
}

// 한건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = {id, first_name, last_name, email, gender, salary}){
	const fields = ['id','first_name','last_name','gender'];
	let tr = document.createElement('tr'); // <tr></tr> 생성.
	// checkbox 생성
	let tdc = document.createElement('td');
	let chk = document.createElement('input')
	chk.setAttribute('type','checkbox');
	// 부모-자식
	tdc.appendChild(chk);
	tr.appendChild(tdc);
	// td 생성
	for (let i=0; i<fields.length; i++){
		let td = document.createElement('td'); // <td>1</td>
		td.innerHTML = emp[fields[i]];
		tr.appendChild(td); // <tr><td>1</td><td>Geneva</td></tr>
	}
	// button 생성.
	let td = document.createElement('td'); // <td>1</td>
	let btn = document.createElement('button');
	btn.setAttribute('class','btn btn-danger');
	btn.innerText = '삭제';
	btn.addEventListener('click',deleteRow);
	// 부모-자식
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}

// btn의 이벤트 핸들러.
function deleteRow(e){
	console.log(e.target);
	e.target.parentElement.parentElement.remove();
}
// checkbox의 이벤트(change) 핸들러 등록.
document.querySelector('thead input[type="checkbox"]').addEventListener('change', function(e){
	// tbody영역의 checkbox의 값 변경
	let checked = e.target.checked; // thead 영역의 checkbox.
	document.querySelectorAll('tbody input[type="checkbox"]').forEach(function(item){
		item.checked = checked;
	})
})
document.querySelector('select#searchGender').addEventListener('change', function(e) {
	let genderValue = e.target.value;
	console.log(e.target.value); // 선택한 성별 값 가져오기
	// dataAry의 배열을 활용해서 출력.
	// dataAry의 gender속성을 비교해서 출력하기(출력하기전에 목록을 초기화.)
	document.querySelector('tbody#target').innerHTML = '';	
	dataAry.forEach(function(item){
		// 같은값만 출력
		if(genderValue == 'all' || item.gender == genderValue){
			let tr = makeRow(item);
			document.querySelector('tbody#target').appendChild(tr);						
		}
	});
});











