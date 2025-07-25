document.querySelector("form").addEventListener("submit", function (e) {
    const email = document.querySelector('input[name="email"]').value;
    const password = document.querySelector('input[name="password"]').value;

    if (!email.includes("@") || password.length < 8) {
        alert("Verifique se o e-mail é válido e se a senha tem pelo menos 8 caracteres.");
        e.preventDefault(); 
    }
});