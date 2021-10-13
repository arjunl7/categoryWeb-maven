/**
 * 
 */

/**
const deleteBtn = document.querySelector(".delete-btn")
const categories = document.querySelectorAll(".checked-cat")


deleteBtn.addEventListener("click",  () => {
	const selectedCat = Array.from(categories).filter((cat) => cat.checked === true && cat.value)
	const selectedIds = selectedCat.map(cat => cat.value)
	
	if(selectedIds.length === 0) {
		window.alert("Category not selected")
	} else if(selectedIds.length > 1) {
		window.alert("Please select one category.")
	} 
	const pathparts = location.pathname.split('/')
	const base_path = window.location.origin+'/'+pathparts[1].trim('/')+'/'
	const formData = new FormData()
	formData.append("catId", selectedIds)
	fetch(`${base_path}/login`, {method: "delete", body: formData})
})
 */

const selAll = document.querySelector(".selectall-cat")
const categories = document.querySelectorAll(".checked-cat")

selAll.addEventListener('click', (e) => {
	if(e.target.checked === true) {
		categories.forEach(cat => cat.checked = true)
	} else {
		categories.forEach(cat => cat.checked = false)
	}
})

