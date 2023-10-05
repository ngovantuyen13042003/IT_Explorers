
function checkPassword() {
    var password = document.getElementById('password').value;
    var passwordConfirm = document.getElementById('confirmPassword').value;
    var passwordError = document.getElementById('confirmPassword');
    var notify = document.querySelector('.text-danger')
    if(password !== passwordConfirm) {
        notify.innerText  = "Enter incorrect password!"
    }else {
        notify.innerText  = ""
    }
}

