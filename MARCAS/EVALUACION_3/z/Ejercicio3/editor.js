function negrita(){
	document.execCommand("bold", false, null);
}
function cursiva(){
	document.execCommand("italic", false, null);
}
function subrayado(){
	document.execCommand("underline", false, null);
}
function alineai(){
	document.execCommand("justifyleft", false, null);
}
function alineac(){
	document.execCommand("justifycenter", false, null);
}
function alinead(){
	document.execCommand("justifyright", false, null);
}
function alineaf(){
	document.execCommand("justifyfull", false, null);
}
function subi(){
	document.execCommand("subscript", false, null);
}
function supi(){
	document.execCommand("superscript", false, null);
}
function listano(){
	document.execCommand("insertunorderedlist", false, null);
}
function listao(){
	document.execCommand("insertorderedlist", false, null);
}
function fontcolor(){
	var color = prompt("Introduce el color de la fuente");
	document.execCommand("forecolor", false, color);
}
function backcolor(){
	var color = prompt("Introduce el color de la fuente");
	document.execCommand("backcolor", false, color);
}
function insertarimg(){
	var imagen = prompt("Introduce la ruta de la imagen");
	document.execCommand("insertimage", false, imagen);
}
function hipervinculo(){
	var direccion = prompt("Introduce la URL:", "Http://");
	document.execCommand("createlink", false, direccion);	
}
function publicar(){
	var conte = document.getElementById("contenido").innerHTML;
	document.getElementById("mensajes").innerHTML += "<div >" + conte + "</div>";
}



