
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