/**
 * 
 */


$(document).ready(() => {

	console.log("Document ready...")
	const listContainer = document.querySelector(".cat-container")
	const ul = document.createElement("ul")
	$(ul).addClass("cat-list")


	$.ajax({
		url: "categoryajax", 
		success: function(result){
			const list = result ? result : []
	   		list.forEach((cat, idx) => {	
				//for each cat item
				const li = document.createElement("li")
				const p = document.createElement("p")
				$(p).text(`${idx+1}. ${cat.name}`)
				
				$(li).append(p)
				$(ul).append(li)
			})
			
			$(listContainer).append(ul)
		}
	});
	
})