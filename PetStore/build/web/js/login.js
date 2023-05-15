// Show login form on button click
document.querySelector('.loginBtn').addEventListener('click', function() {
document.querySelector('.login').style.display = 'block';
document.querySelector('.signUp').style.display = 'none';
// border bottom on button click
document.querySelector('.loginBtn').style.borderBottom = '2px solid rgb(243, 147, 91)';
// remove border after click
document.querySelector('.signUpBtn').style.borderStyle = 'none';
});

// Show sign Up form on button click
document.querySelector('.signUpBtn').addEventListener('click', function() {
document.querySelector('.login').style.display = 'none';
document.querySelector('.signUp').style.display = 'block';
// border bottom on button click
document.querySelector('.signUpBtn').style.borderBottom = '2px solid rgb(243, 147, 91)';
// remove border after click
document.querySelector('.loginBtn').style.borderStyle = 'none';
});