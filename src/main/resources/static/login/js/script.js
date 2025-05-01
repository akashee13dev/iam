
function togglePassword(type) {
    var passwordField = document.getElementById(type+"-password");
    var eyeIcon = document.getElementById(type+"-toggle-password");

    if (passwordField.type === "password") {
        passwordField.type = "text";
        eyeIcon.textContent = "🙈";  // Change icon to "Hide"
    } else {
        passwordField.type = "password";
        eyeIcon.textContent = "👁️";  // Change icon to "Show"
    }
}

function createUser(){
    var email = document.getElementById("signup-email").value;
    var name = document.getElementById("signup-name").value;
    var password = document.getElementById("signup-password").value;

    var user = {
        email: email,
        password: password,
        name : name
    };

    axios.post('/akash/signup', user)
        .then(function (response) {
            console.log("Signup successful:", response);
        })
        .catch(function (error) {
            console.error("Signup failed:", error.response.data);
        });
}