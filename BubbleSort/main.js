function bbsort() {
  var n = document.getElementById("size").value;
  var a = new Array();
  var stringarr = document.getElementById("arrele").value;
  a = stringarr.strip().split(" ");
  var regex = /^[," "]/;
  if (n != a.length) {
    alert("Enter given number of elements!!");
    return;
  }
  if (!regex.test(a)) {
    for (var i = 0; i < n - 1; i++) {
      for (var j = i + 1; j < n; j++) {
        if (a[j] < a[i]) {
          var temp;
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
    var temp = "";
    for (var i = 0; i < n; i++) {
      temp += a[i] + ",";
    }
    alert("Sorted array is: " + temp);
  } else alert("Array must not start with special characters");
}
