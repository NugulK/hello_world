<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>gov.jsp</title>
	<link href="css/styles.css" rel="stylesheet" />
</head>

<body>
	시도선택:<select id="choice" class="form-control">

	</select>

	<!-- 센터목록테이블 -->
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>센터명</th>
				<th>연락처</th>
				<th>시도정보</th>
			</tr>
		</thead>
		<tbody id="centerList">
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
	<script>
		let url =
			'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=0UrtEkTzq%2BKR5T0ZBU16QSoAmXFfNV3GqiLUFK%2FVeIs%2B2Cy7pDwFfeQeIqOetmZ2qnBuR3j5PKJNOSOIuMRN5A%3D%3D';
		let centerList = []; // Array.filter(), Array.reduce().
		fetch(url)
			.then(result => result.json())
			.then(result => {
				console.log(result);
				centerList = result.data; //센터전체.
				let sidoAry = []; // 284건의 센터정보.
				centerList.forEach(center => {
					if (sidoAry.indexOf(center.sido) == -1) {
						sidoAry.push(center.sido); // 중복되지 않은 값만 등록.
					}
				})
				console.log(sidoAry);
				// 시도 정보 생성(option태그 생성.)
				sidoAry.forEach(sido => {
					let opt = document.createElement('option');
					opt.innerHTML = sido;
					document.querySelector('#choice').appendChild(opt);
				})

				// 초기목록 출력(10개).
				centerList.forEach((center, idx) => {
					if (idx < 10) {
						let tr = makeCenter(center); // center의 정보를 활용 tr생성.
						document.querySelector("#centerList").appendChild(tr);
					}
				})
			})
			.catch(err => console.error(err))

		// 이벤트.. this 1) 함수 : window 2) 이벤트 : 이벤트대상
		document.querySelector('#choice').addEventListener('change', function (e) {
			let val = this.value;
			document.querySelector('#centerList').innerHTML = "";

			centerList//
				.filter(center =>  center.sido == val)
				.forEach((center, idx) => {
					let tr = makeCenter(center); // center의 정보를 활용 tr생성.
					document.querySelector("#centerList").appendChild(tr);
				})
		}) // end of event.

		//센터 정보를 활용해서 tr생성하는 함수.
		function makeCenter(center = {}) {
			let tr = document.createElement('tr');

			// ✅ tr 클릭 이벤트 수정
			tr.addEventListener('click', function (e) {
				openWindow(center);
			});

			let fields = ['id', 'centerName', 'phoneNumber', 'sido'];
			fields.forEach(field => {
				let td = document.createElement('td');
				td.innerHTML = center[field];
				tr.appendChild(td);
			});

			return tr;
		}

		// ✅ openWindow도 수정
		function openWindow(center) {
			window.open('map.jsp?lat=' + center.lat + '&lng=' + center.lng);
		}
	</script>
</body>

</html>