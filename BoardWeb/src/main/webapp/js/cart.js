/**
 *  cart.js
 */
// 수량증가
const basket = {
	changePNum: function(index, type) {
		const input = document.getElementById('p_num' + index);  // 수량 input
		const priceInput = document.getElementById('p_price' + index); // // 가격 input
		const sumInput = document.getElementById('sum' + index); //합계 표시 div


		let currentValue = parseInt(input.value) || 0;
		let price = parseInt(priceInput.value) || 0;

		if (type === 'up') {
			currentValue += 1;
		} else if (type === 'down') {
			if (currentValue > 1) {
				currentValue -= 1;
			}
		}
		input.value = currentValue;

		// 상품별 합계 계산해서 화면에 표시.
		let sum = currentValue * price;
		sumInput.innerText = sum.toLocaleString() + '원';

		//  전체 합계도 다시 계산
		basket.updateTotal();
	},
	// 상품 하나 삭제
	delItem: function(index) {
		const itemRow = document.getElementById('row' + index);
		if (itemRow) {
			itemRow.remove(); // 해당 상품 줄 삭제.
			basket.updateTotal(); // 합계 다시 계산
		}
	},

	// 전체 합계 계산.
	updateTotal: function() {
		const quantityInputs = document.querySelectorAll('.p_num');
		const priceInputs = document.querySelectorAll('.p_price');

		let total = 0;
		let totalQuantity = 0;  // 전체 상품 갯수

		quantityInputs.forEach(function(input, index) {
			let quantity = parseInt(input.value) || 0;
			let price = parseInt(priceInputs[index].value) || 0;

			total += quantity * price;
			totalQuantity += quantity; // 상품 수량더하기
		})
		// ✅ 총 합계 금액 업데이트
		const totalPriceElement = document.getElementById('sum_p_price');
		if (totalPriceElement) {
			totalPriceElement.innerHTML = '합계금액: <span>' + total.toLocaleString() + '</span>원';
		}
		// ✅ 상품 개수도 같이 업데이트
		const totalCountElement = document.getElementById('sum_p_num');
		if (totalCountElement) {
			totalCountElement.innerHTML = '상품갯수: <span>' + totalQuantity + '</span>개';
		}
	},

	// 선택한 상품만 주문
	orderSelectedItem: function() {
		const selectedItems = document.querySelectorAll('input[name=buy]:checked');

		if (selectedItems.length === 0) {
			alert('선택한 상품이 없습니다!');
			return;
		}

		let totalQuantity = 0;
		let totalPrice = 0;
		let selectedValues = [];

		selectedItems.forEach(function(item) {
			const row = item.closest('.row');
			if (row) {
				const quantityInput = row.querySelector('.p_num');
				const priceInput = row.querySelector('.p_price');

				let quantity = parseInt(quantityInput ? quantityInput.value : 0) || 0;
				let price = parseInt(priceInput ? priceInput.value : 0) || 0;

				totalQuantity += quantity;
				totalPrice += quantity * price;

				selectedValues.push(item.value);
			}
		});

		// 주문 확인창
		const isConfirmed = confirm(
			'선택한 상품을 주문하시겠습니까?\n' +
			'상품갯수: ' + totalQuantity + '개\n' +
			'총 금액: ' + totalPrice.toLocaleString() + '원'
		);

		if (isConfirmed) {
			alert('주문이 완료되었습니다! 🎉');
			// 여기서 서버로 주문 데이터 보내기 가능
		}
	},
	// 선택 상품 삭제.
	delCheckedItem: function() {
		const checkedItems = document.querySelectorAll('input[name=buy]:checked');

		if (checkedItems.length === 0) {
			alert('선택된 상품이 없습니다!');
			return;
		}
		checkedItmes.forEach(function(item) {
			const row = item.closest('.row');
			if (row) {
				row.remove();
			}
		});

		basket.updateTotal();

	},
	// 장바구니 비우기.
	delAllItem: function() {
		const allRows = document.querySelectorAll('.row.data');

		if (allRows.length === 0) {
			alert('장바구니가 이미 비었습니다!');
			return;
		}

		allRows.forEach(function(row) {
			row.remove();
		});

		basket.updateTotal();
	}
};
