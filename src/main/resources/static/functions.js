$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(ev){
		// var q_text_input = $('input#q');
		// var content = '<div class="row panel panel-default" th:fragment="content" th:each="tweet: ${res.tweets}">' 
		// 			+ '	<div class="panel-heading">'
		// 			+ '		<a href="https://twiter.com/jracing_rte" th:href="@{https://twiter.com/{user}(user=${tweet.fromUser})}" target="_blank"><b th:text="${\'@\'+tweet.fromUser}">@jracing_rte</b></a>'
		// 			+ '		<div class="pull-right">'
		//			+ '			<a href="https://twiter.com/jracing_rte/status/556867274335059969" th:href="@{https://twiter.com/{user}/status/{id}(user=${tweet.fromUser},id=${tweet.id})}" target="_blank"><span class="glyphicon glyphicon-link"></span></a>'
		// 			+ '		</div>'
		// 			+ '	</div>'
		// 			+ '	<div class="panel-body" th:text="${tweet.unmodifiedText}">CR28: iguala el record de Messi en la primera vuelta http://t.co/zmYnja4gYP vía @marca</div>'
		// 			+ '</div>';

		$.get($(this).attr('action'), {q: $("#q").val()}, function(data) {
			console.log(data);
			$("#resultsBlock").empty().append(data);
		});

		event.preventDefault();
	});
}