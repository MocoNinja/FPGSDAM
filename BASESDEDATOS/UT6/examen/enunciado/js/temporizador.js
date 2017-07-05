var c=-1;
function mostrarImagenes(){
imagenes=new Array('./imagenes/enero.jpg', './imagenes/febrero.jpg', './imagenes/marzo.jpg', './imagenes/abril.jpg', './imagenes/mayo.jpg','./imagenes/junio.jpg','./imagenes/julio.jpg','./imagenes/agosto.jpg','./imagenes/septiembre.jpg','./imagenes/octubre.jpg','./imagenes/noviembre.jpg','./imagenes/diciembre.jpg')
if(c==11){c=0}else{c++}
folleto.src=imagenes[c]
$("#folleto").animate({opacity:0.5},2000);
$("#folleto").animate({opacity:1},2000);
setTimeout('mostrarImagenes()', 5000)
}