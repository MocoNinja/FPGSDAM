window.onload = function() // Ver similitud con JQuery
{
	// alert("Entra");
	var canvas = document.getElementById("canvas");
	if(canvas.getContext) // Es el lugar donde trabajar
	{
		var ctx = canvas.getContext("2d");
    ctx.fillRect(0, 0, 100, 100);
    ctx.clearRect(25, 25, 50, 50);
    ctx.strokeRect(27, 27, 45, 45); 
	}
}