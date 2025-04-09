/**
 *  board2.js
**/

const table = new DataTable('#example', {
    ajax: 'replyListDatatable.do?bno='+bno ,
    columns: [
        { data: 'REPLY_NO' },
        { data: 'REPLY' },
        { data: 'REPLYER' },
        { data: 'REPLY_DATE' }
    ],
	lengthMenu: [
	       [5, 10, 25, 50, -1],
	       [5, 10, 25, 50, 'All']
	],
	order: [[0, 'desc']]
});
// 등록.
function addNewRow() {
	let replyContent = document.querySelector('#reply').value; // 입력값

	if (replyContent === '') {
		alert('댓글 내용을 입력하세요.');
		return;  // 빈 값이면 fetch 요청 자체를 보내지 않는다!
	}

	fetch('addReply.do?bno=' + bno + '&replyer=' + replyer + '&reply=' + replyContent)
		.then(result => result.json())
		.then(result => {
			console.log(result);
			if (result.retCode === 'OK') {
				let item = result.retVal;
				table.row
					.add({
						REPLY_NO: item.replyNo,
						REPLY: item.reply,
						REPLYER: item.replyer,
						REPLY_DATE: item.replyDate
					})
					.draw(false);

				document.querySelector('#reply').value = ''; // 등록 후 입력창 비우기
			} else {
				alert('등록 실패!');
			}
		})
		.catch(err => console.error(err));
}

document.querySelector('#addRow').addEventListener('click', addNewRow);


// 삭제. 
let selectedRow = null; // ✅ 전역 변수로 선택된 행 저장

// 댓글 하나 클릭했을 때
table.on('click', 'tbody tr', (e) => {
	
    selectedRow = e.currentTarget; // ✅ 클릭한 tr을 저장

    let classList = selectedRow.classList;

    if (classList.contains('selected')) {
        classList.remove('selected');
    } else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
    }
});

// 삭제 버튼 클릭했을 때
document.querySelector('#button').addEventListener('click', function () {
    if (!selectedRow) {
        alert('삭제할 댓글을 선택하세요.');
        return;
    }

    // 삭제할 글번호 찾아오기
    let rno = selectedRow.children[0].innerHTML; // ✅ 첫 번째 td에서 글번호 가져오기

    // 서버에 삭제 요청 보내기
    fetch('removeReply.do?rno=' + rno)
        .then(result => result.json())
        .then(result => {
            if (result.retCode === 'OK') {
                alert('삭제 성공!');
                table.row('.selected').remove().draw(false); // 화면에서도 삭제
                selectedRow = null; // ✅ 삭제 완료 후 선택 해제
            } else {
                alert('삭제 실패!');
            }
        })
        .catch(err => {
            console.error(err);
            alert('서버 통신 오류 발생!');
        });
});

