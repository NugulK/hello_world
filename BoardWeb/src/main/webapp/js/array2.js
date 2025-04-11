/**
 * js/array2.js
 */
const numAry = [10, 17, 23, 26, 49];
let filterAry = numAry.filter(function(item, idx, ary){
	return item % 2 == 0 ; // true 값을 반환하는 item을 배열로 저장.
});
console.log(filterAry);

const jsonStr = `[{"id":1,"first_name":"Yoshiko","last_name":"Tiller","email":"ytiller0@statcounter.com","gender":"Female","salary":1595},
{"id":2,"first_name":"Geneva","last_name":"MacKessock","email":"gmackessock1@cam.ac.uk","gender":"Female","salary":4199},
{"id":3,"first_name":"Shirley","last_name":"Ryder","email":"sryder2@addtoany.com","gender":"Female","salary":2865},
{"id":4,"first_name":"Abeu","last_name":"Ayres","email":"aayres3@tiny.cc","gender":"Male","salary":3243},
{"id":5,"first_name":"Oliy","last_name":"Matuskiewicz","email":"omatuskiewicz4@howstuffworks.com","gender":"Female","salary":3893},
{"id":6,"first_name":"Carri","last_name":"Aspinal","email":"caspinal5@guardian.co.uk","gender":"Female","salary":9565},
{"id":7,"first_name":"Lynne","last_name":"Kalinovich","email":"lkalinovich6@archive.org","gender":"Female","salary":8868},
{"id":8,"first_name":"Kelsi","last_name":"Bristo","email":"kbristo7@cornell.edu","gender":"Agender","salary":5265},
{"id":9,"first_name":"Boone","last_name":"Blenkinship","email":"bblenkinship8@disqus.com","gender":"Male","salary":4854},
{"id":10,"first_name":"Katusha","last_name":"Rowsell","email":"krowsell9@phpbb.com","gender":"Female","salary":1993},
{"id":11,"first_name":"Skylar","last_name":"Roseblade","email":"srosebladea@meetup.com","gender":"Male","salary":6802},
{"id":12,"first_name":"Rosabel","last_name":"Stubley","email":"rstubleyb@tumblr.com","gender":"Female","salary":1498},
{"id":13,"first_name":"Karole","last_name":"Vasyushkhin","email":"kvasyushkhinc@artisteer.com","gender":"Female","salary":6520},
{"id":14,"first_name":"Piotr","last_name":"Rousell","email":"prouselld@ehow.com","gender":"Male","salary":8059},
{"id":15,"first_name":"Woody","last_name":"Lechmere","email":"wlechmeree@businessweek.com","gender":"Bigender","salary":2104}]`;
const jsonAry = JSON.parse(jsonStr);
// {id, first_name, last_name, email, gender, salary}
// 화살표 함수를 사용하여 줄임.
filterAry = jsonAry.filter(item => item.gender == "Male" && item.salary >= 5000);
console.log(filterAry);

// reduce() : 배열메소드 acc: 
console.clear();
let result = [10, 23, 34, 48, 51].reduce(function(acc, item, idx, ary){
	console.log(acc, item);
	if(item > 30){
		acc.push(item);
	}
	return acc; // acc값으로 활용.
}, []);
console.log('result :'+ result);
console.clear();
let list = document.querySelector('#list'); // <ul id="list"/>
[10, 23, 34, 48, 51].reduce((acc, item) => {
	let li = document.createElement('li');
	li.innerHTML = item; // <li>10</li>
	acc.appendChild(li);
	
	return acc;
}, list);

const ary = [
	{name: "홍길동", phone: "010-1111-2222"},
	{name: "김길동", phone: "010-3333-4444"},
	{name: "나길동", phone: "010-5555-6666"},
	{name: "박길동", phone: "010-7777-8888"},
	{name: "이길동", phone: "010-9999-0000"}
]
// reduce() 메소드를 활용해서 li에 값에 홍길동 , 연락처 이렇게 출력되게 하기. 
list = document.querySelector('#list');
	ary.reduce((acc, item) => {
		let li = document.createElement('li');
		li.innerHTML = '이름:'+item.name +' 전화번호:'+ item.phone;
		acc.appendChild(li);
			
		return acc;
}, list)