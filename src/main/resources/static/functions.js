$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(event){
		var q_text_input = $('input#q');
		var content = '<div class="row panel panel-default">' 
					+ '</div>';

		$.get($(this).attr('action'), {q: q_text_input.val()}, function(tweets) {
			console.log(tweets);
			$.each(tweets, function(key, tweet){
				content +='<div class="panel-heading">'
						+ '		<a href="https://twiter.com/'+ tweet.fromUser +'" target="_blank"><b>@'+ tweet.fromUser +'</b></a>'
						+ '		<div class="pull-right">'
						+ '			<a href="https://twiter.com/'+ tweet.fromUser +'/status/'+ tweet.id +'" target="_blank"><span class="glyphicon glyphicon-link"></span></a>'
						+ '		</div>'
						+ '</div>'
						+ '<div class="panel-body">'+ tweet.unmodifiedText +'</div>'
			});
			$("#resultsBlock").empty().append(content);
		});

		event.preventDefault();
	});
}