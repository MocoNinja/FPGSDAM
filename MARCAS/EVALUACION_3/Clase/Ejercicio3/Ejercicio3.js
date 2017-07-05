/* Nuestra propia librería chaval */

var numeroMensaje = 1;
function negrita()
{
    document.execCommand("bold", false, null); // Esta función es nueva: Pide un string de la marca a ejecutar, un booleano de si quiere visualizarse la marca y un value
}

function cursiva()
{
    document.execCommand("italic", false, null);
}

function subrayado()
{
    document.execCommand("underline", false, null);
}

function alinearIzquierda()
{
    document.execCommand("justifyleft", false, null);
}

function alinearJustificado()
{
    document.execCommand("justifyfull", false, null);
}

function alinearCentro()
{
    document.execCommand("justifycenter", false, null);
}

function alinearDerecha()
{
    document.execCommand("justifyright", false, null);
}

function subindice()
{
    document.execCommand("subscript", false, null);
}
function superindice()
{
    document.execCommand("superscript", false, null);
}

function listaDesordenada()
{
    document.execCommand("insertunorderedlist", false, null);
}

function listaOrdenada()
{
    document.execCommand("insertorderedlist", false, null);
}

function colorFondo()
{
    var color = prompt("Elige el color de el fondo:");
    document.execCommand("backcolor", false, color);
}

function colorTexto()
{
    var color = prompt("Elige el color de la fuente:");
    document.execCommand("forecolor", false, color);
}

function hipervinculo()
{
    var hipervinculo = prompt("Introduce la url", "https://");
    document.execCommand("createlink", false, hipervinculo);
}

function insertarImagen()
{
    var imagen = prompt("Introduce la ruta de la imagen");
    document.execCommand("insertimage", "false", imagen);
}

function publicar()
{
    var contenido = document.getElementById("contenido").innerHTML;
    document.getElementById("mensajes").innerHTML += ("<div>" + "Mensaje número " + numeroMensaje++ + ": " + contenido + "</div>");
}