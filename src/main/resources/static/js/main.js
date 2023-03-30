const inpFile = document.querySelector("#formFile");
const preview = document.querySelector("#preview");
const  form = document.querySelector("#formMain");
const btnSend  = document.querySelector("#btnSend");
const imgContent = document.querySelector("#img-content");
var saveData= [];



	
	this.URL="https://api.imgbb.com/1/upload"



	 
	 
fetch(this.URL)
.then(res => res.json())
.then(data => {
	console.log(data)

 })




