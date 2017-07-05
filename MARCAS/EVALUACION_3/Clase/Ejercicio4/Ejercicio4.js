window.onload = function() // Ver similitud con JQuery
{
	// alert("Entra");
	var canvas = document.getElementById("canvas");
	if(canvas.getContext) // Es el lugar donde trabajar
	{
	var ctx = canvas.getContext("2d");
    ctx.fillStyle = "rgb(255, 0, 0)";
    ctx.fillRect(0, 0, 100, 100);
    ctx.fillStyle = "rgba(0, 0, 255, .5)";
    ctx.fillRect(50, 50, 100, 100);
	}
}