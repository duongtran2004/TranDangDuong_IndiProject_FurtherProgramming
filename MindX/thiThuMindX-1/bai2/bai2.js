function numberOneTriangle(n) {
  //print the columns
  for (i = 1; i <= n; i++) {
    //print the row
    for (j = 1; j <= i; j++) {
      //write the stars
      document.write("* ");
    }
    //break the line
    document.write("<br>");
  }
}
//call the function
numberOneTriangle(7);
