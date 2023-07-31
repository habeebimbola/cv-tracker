const message = 'Welcome To The Guess Word Puzzle!';
console.log(`${message}`);

const method = 'POST';
const request = new XMLHttpRequest();
const url = "http://localhost:9000/guessWord/";

const submitForm = document.getElementById("submitForm");
const inputGuess = document.getElementById('guessedWordInput');

const body = document.getElementById('body');

submitForm.addEventListener('mouseover',()=>{
    inputVal = inputGuess.value;
    console.log(`${inputVal}`);
    request.open(method,url);
    request.send();
    request.onload = (e) => {
    console.log(''+request.response );
}
});

console.log(`${inputGuess}`);

