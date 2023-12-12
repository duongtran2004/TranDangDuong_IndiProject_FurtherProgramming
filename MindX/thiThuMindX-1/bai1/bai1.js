document
  .getElementById("calculateBtn")
  .addEventListener("click", function getPrimeSum() {
    // get user input from the input field in html file
    let a = parseInt(document.querySelector("#a").value);
    let b = parseInt(document.querySelector("#b").value);
    //Check for invalid input

    if (isNaN(a) || isNaN(b) || a >= b) {
      //return message to user
      alert("Vui lòng nhập lại số a và b sao cho a < b và đều là số.");
      // escape the function
      return;
    }
    //variabale to hold array of prime numbers
    let primeList = [];
    //Step 1: Print all prime numbers in the range
    function printPrimeInRange() {
      //loop from a to b
      for (i = a; i <= b; i++) {
        //declare initial primeNumber variab;e
        let isPrime = true;
        //loop all numbers from 2 to i (j), stop when j  is divisible by i, so i is not a prime
        for (let j = 2; j < i; j++) {
          if (i % j === 0) {
            isPrime = false;
            break; // No need to check further if it's divisible
          }
        }
        // print the number if isPrime = true
        if (i > 1 && isPrime) {
          console.log(i);
          //store i in an array (primeList)
          primeList.push(i);
          console.log(primeList);
        }
      }
    }
    printPrimeInRange();
    //Step 2: Add all prime number in primeList array together
    //   declare initial sum value of prime number
    let primeSum = 0;
    //loop through each element in primeList and add them to primeSum
    primeList.forEach((prime) => {
      primeSum += parseInt(prime);
    });
    //display the result
    document.getElementById("primeNumbers").innerText =
      "Các số nguyên tố trong khoảng từ " +
      a +
      " đến " +
      b +
      " là: " +
      primeList.join(", ");
    document.getElementById("primeSum").innerText =
      "Tổng các số nguyên tố trong khoảng là: " + primeSum;
  });
getPrimeSum();
