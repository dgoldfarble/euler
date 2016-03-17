
window.onload = function() {
  var answer = problem43();
  console.log(answer);
}

function problem43(max) {
  var sum = 0;
  for (var i = 1000000000; i < 10000000000; i++) {
    if (i % 1000000000 === 0) {
      console.log(i);
    }
    if (isPandigital(i) &&
      substringProperty(i)) {
      sum = sum + i;
    }
  }
  return sum;
}

function isPandigital(number) {
  var array = number.toString();
  for (var i = 0; i < array.length; i++) {
    if (!array.includes(i.toString())) {
      return false;
    }
  }
  return true;
}

function substringProperty(number) {
  var string = number.toString();
  if (string.length != 10) {
    return false;
  }
  if (!(Number(string.substr(1, 3)) % 2 === 0)) {
    return false;
  }
  if (!(Number(string.substr(2, 3)) % 3 === 0)) {
    return false;
  }
  if (!(Number(string.substr(3, 3)) % 5 === 0)) {
    return false;
  }
  if (!(Number(string.substr(4, 3)) % 7 === 0)) {
    return false;
  }
  if (!(Number(string.substr(5, 3)) % 11 === 0)) {
    return false;
  }
  if (!(Number(string.substr(6, 3)) % 13 === 0)) {
    return false;
  }
  if (!(Number(string.substr(7, 3)) % 17 === 0)) {
    return false;
  }
  return true;
}
