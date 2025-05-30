<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <script src='js/index.global.js'></script>
  <script>
  document.addEventListener('DOMContentLoaded', async function () {
	  var calendarEl = document.getElementById('calendar');
	  
	  console.log('1');
	  var events = [];
	  // Ajax call.
	  
	  console.log('2');
	  let result = await fetch('eventList.do');
	  let result2 = await result.json(); 
	  console.log(result2);
	  events = result2;

	  console.log('3');
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      headerToolbar: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
	      },
	      initialDate: '2025-04-12',
	      navLinks: true,
	      selectable: true,
	      selectMirror: true,
	      select: async function (arg) {
	    	  console.log(arg);
	        var title = prompt('Event Title:');
	        if (title) {
	          let allDay = arg.allDay; // 하루전체일정, 부분일정.
	          let start = allDay ? arg.startStr : arg.startStr.substring(0, 19);
	          let end = allDay ? arg.endStr : arg.endStr.substring(0, 19);
	         
	          //let r1 = await fetch('addevent.do?title=' + title + '&start=' + start + '&end=' + end);
	          let r1 = await fetch('addevent.do', {
	        	  method: 'post',
	        	  headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	        	  body: 'title=' + title + '&start=' + start + '&end=' + end
	          });
	          let r2 = await r1.json();
	          
	          if (r2.retCode == 'OK'){
		          calendar.addEvent({
		            title: title,
		            start: arg.start,
		            end: arg.end,
		            allDay: arg.allDay
		          })
	          }else{
	         	 alert('등록실패');
	          }
	        } // end of if(title)
	        calendar.unselect();
	      },
	      eventClick: async function (arg) {
	    	  console.log(arg);
	          if (confirm('Are you sure you want to delete this event?')) {
	            let xhtp = await fetch('removeEvent.do?title=' + arg.event.title + '&start=' + arg.event.startStr + '&end=' + arg.event.endStr);
	            let result = await xhtp.json();
	            if (result.retCode == 'OK') {
	              arg.event.remove();
	            } else {
	              alert('Transaction error!');
	            }
	          }
	      },
	      editable: true,
	      dayMaxEvents: true,
	      events: events
	    });
	    calendar.render();
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
  <h4>event.jsp</h4>
  <div id='calendar'></div>
</body>

</html>