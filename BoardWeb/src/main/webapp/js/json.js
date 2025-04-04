/**
 *  json.js
 */

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

let obj = JSON.parse(jsonStr); // json문자열 -> object 변경.
let str = JSON.stringify(obj); // object -> json문자열 변경.
console.log(obj[2].last_name);

// 한건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = {id, first_name, last_name, email, gender, salary}){
	const fields = ['id','first_name','last_name','email'];
	let tr = document.createElement('tr'); // <tr></tr> 생성.
	for (let i=0; i<fields.length; i++){
		let td = document.createElement('td'); // <td>1</td>
		td.innerHTML = emp[fields[i]];
		tr.appendChild(td); // <tr><td>1</td><td>Geneva</td></tr>
	}
	return tr;
}

//화면 출력.
obj.forEach(function(item, idx, ary){
	let tr = makeRow(item);
	document.querySelector('tbody#target').appendChild(tr);
})