
	var result=0;
	var evalu=0;
function takeValue(x) {
	var y=x;
	document.getElementById('inputwindow').value += x;
	
}

function clearInput(y) {
	document.getElementById('inputwindow').value = y;
	result=0;
	var li = document.getElementById('foodlist');
	document.getElementById('inputwindow2').value = y;
	result=0;
	 li.textContent = '';
	 evalu=0;
}

function calculateResult() {
	if (evalu!=1){
	result = document.getElementById('inputwindow').value;
	  var total=result

  var li = document.createElement("li");
  li.textContent = 'Total a pagar: $' + total ;
  document.getElementById("foodlist").appendChild(li);
  evalu=1;
	}	
}
function show(x){
	resultado=x
	document.getElementById('inputwindow2').value = resultado
	}
function addResult(x){
	result=parseInt(x)+parseInt(result);
	document.getElementById('inputwindow').value = result
	
	}
 function addToList(x,y) {
 	if (evalu!=1){
  var fish = x;
  var amount = y;

  var li = document.createElement("li");
  li.textContent = fish + ': $' + amount ;
  document.getElementById("foodlist").appendChild(li);
  }
}
