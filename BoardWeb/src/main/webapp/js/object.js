/**
 * object.js
 */
console.log("start");

// DOM 제어.
let li = document.createElement('li'); // 새로운요소 생성.
li.innerText = 'cherry';

document.querySelector('ul#list').appendChild(li); // 자식요소 추가.
document.querySelector('ul#list').style.display = 'none';


let name= "Hong"; // 값이 할당되는 시점에 type정해짐.
name = 100;
console.log(typeof name);

const obj = {
	name: "홍길동",
	age: 20,
	friends: ['김길동','박길동'],
	pets: [{name:'멍멍이',age:3},{name:'야옹이',age:2}]
}
obj.height = 165.8;

console.log(typeof obj);
console.log(obj.name, obj["age"]);
console.log('첫번째친구',obj['friends'][0]);
console.log('첫번째 동물이름',obj.pets[0].name,'나이는',obj.pets[0].age,'살');
// 최길동이라는 친구 추가.
obj.friends[2] = '최길동';
// 친구목록 출력.
for(let i=0; i<obj.friends.length; i++){
	console.log('친구이름:',obj.friends[i]);
} 
// name:짹짹이, age:1 애완동물 추가.
obj.pets.push({name:'짹짹이',age:1});

// 애완동물 목록출력 for of 사용 화면출력.
// <table> <thead><tr><th></th></tr> </thead><tbody>....</tbody></table>
let tblHtml = '<table class="table">';
tblHtml += '<thead><tr><th>이름</th><th>나이</th></tr></thead>';
tblHtml += '<tbody>';
for(let pet of obj.pets){
	console.log(`애완동물의 이름은 ${pet.name}, 나이는 ${pet.age}`);
	tblHtml += '<tr><td>'+pet.name +'</td><td>'+pet.age+'</td></tr>';
}
tblHtml += '</tbody>';

document.querySelector('nav+div.container-fluid').innerHTML += tblHtml;


