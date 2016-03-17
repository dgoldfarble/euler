
window.onload = function() {
  var answer = problem39(1000);
  console.log(answer);
}

function problem39(max) {
  var arr = new Array();
  for (var i = 0; i <= max; i++) {
    arr[i] = 0;
  }
  var a = 2;
  var b = 2;
  var c = Math.sqrt(a * a + b * b);
  while(a + b + c <= max) {
    while (a + b + c <= max) {
      if (isInteger(c)) {
        arr[a + b + c]++;
      }
      b++;
      c = Math.sqrt(a * a + b * b);
    }
    var b = a;
    var c = Math.sqrt(a * a + b * b);
    a++;
  }
  var result = [0, 0];
  for (var i = 0; i <= max; i++) {
    if (arr[i] > result[1]) {
      result = [i, arr[i]];
    }
  }
  return result[0];
}

function isInteger(number) {
  if (Math.floor(number) === Math.ceil(number)) {
    return true;
  }
  return false;
}
