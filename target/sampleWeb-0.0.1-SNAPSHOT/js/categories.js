/**
 * 
 */

const listContainer = document.querySelector(".cat-container")

const loader = document.createElement("h6")
const ul = document.createElement("ul")
ul.className = "cat-list"

//const catList = ['Home', "Electronics", "Mobiles"]

const xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function(data) {
	if (this.readyState == 4 && this.status == 200) {
		const catList = JSON.parse(this.response)
		catList.forEach((cat, idx) => {	
			//for each cat item
			const li = document.createElement("li")
			const p = document.createElement("p")
			p.innerHTML = `${idx+1}. ${cat.name}`
			li.appendChild(p)
			ul.appendChild(li)
		})
		
		listContainer.appendChild(ul)
		console.log(catList)
		//console.log(this.response)
    }
}
xhttp.open("GET", "categoryajax", true);
xhttp.send();