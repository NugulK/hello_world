<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='js/index.global.js'></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var events = [];

    // Ajax call
    fetch('eventList.do')
      .then(result => result.json())
      .then(eventListCallback)
      .catch(err => console.error(err))
    
    function eventListCallback(result){
    	//events = result; // json문자열 -> events 변수 할당
      	result.forEach(item => {
      		events.push({title: item.title, start: item.startDate, end: item.endDate})
      	})
   	console.log(events)
    	
    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2025-04-09',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
    	  var title = prompt('이벤트 제목을 입력하세요:');
    	  if (title) {
    	    fetch('addevent.do', {
    	      method: 'POST',
    	      headers: {
    	        'Content-Type': 'application/x-www-form-urlencoded'
    	      },
    	      body: 'title=' + encodeURIComponent(title)
    	          + '&start=' + encodeURIComponent(arg.startStr)
    	          + '&end=' + encodeURIComponent(arg.endStr)
    	    })
    	    .then(response => response.text())
    	    .then(data => {
    	      if (data === 'success') {
    	        alert('이벤트가 추가되었습니다.');
    	        
    	        calendar.addEvent({
    	          title: title,
    	          start: arg.start,
    	          end: arg.end,
    	          allDay: arg.allDay
    	        });
    	      } else {
    	        alert('이벤트 추가 실패');
    	      }
    	    })
    	    .catch(err => console.error('에러 발생:', err));
    	  }
    	  calendar.unselect();
    	},
      eventClick: function(arg) {
    	  if (confirm('이 이벤트를 삭제할까요?')) {
   		    // 서버에 삭제 요청 보내기
   		    fetch('removeEvent.do', {
   		      method: 'POST',
   		      headers: {
   		        'Content-Type': 'application/x-www-form-urlencoded'
   		      },
   		      body: 'title=' + encodeURIComponent(arg.event.title)
   		          + '&start=' + encodeURIComponent(arg.event.startStr)
   		    })
   		    .then(response => response.text())
   		    .then(data => {
   		      if (data === 'success') {
   		        alert('삭제되었습니다.');
   		        arg.event.remove(); //화면에서도 삭제
   		      } else {
   		        alert('삭제 실패');
   		      }
   		    })
   		    .catch(err => console.error('삭제 중 에러 발생:', err));
   		  }
    	},
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events

      events: events
    })
    calendar.render();
    } // end of eventListCallback()
  });
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>