$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(event){
		var q_text_input = $('input#q');
		var content = '';

		$.get($(this).attr('action'), {q: q_text_input.val()}, function(tweets) {
			console.log(tweets);
			$.each(tweets, function(key, tweet){
				content +='<div class="row panel panel-default">'
						+ '<div class="panel-heading">'
						+ '		<a href="https://twitter.com/'+ tweet.fromUser +'" target="_blank"><b>@'+ tweet.fromUser +'</b></a>'
						+ '		<div class="pull-right">'
						+ '			<a href="https://twitter.com/'+ tweet.fromUser +'/status/'+ tweet.idStr +'" target="_blank"><span class="glyphicon glyphicon-link"></span></a>'
						+ '		</div>'
						+ '</div>'
						+ '<div class="panel-body">'+ tweet.unmodifiedText +'</div>'
						+ '</div>';
			});
			$("#resultsBlock").empty().append(content);
		});

		event.preventDefault();
	});
}