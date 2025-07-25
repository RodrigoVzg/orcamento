document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('formLogin');
    const returns = document.getElementById('returns');

    form.addEventListener('submit', async function (event) {
        event.preventDefault();

        const email = document.getElementById('email').value.trim();
        const password = document.getElementById('password').value;

        try {
            const response = await fetch('/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ email, password })
            });

            const text = await response.text(); // Captura mesmo em erro

            if (response.ok) {
                returns.textContent = '✅ Login bem-sucedido!';
                returns.style.color = 'green';
                setTimeout(() => {
                    window.location.href = '/index.html';
                }, 1000);
            } else {
                returns.textContent = text || '❌ Erro desconhecido ao fazer login.';
                returns.style.color = 'red';
            }
        } catch (err) {
            returns.textContent = '❌ Erro ao conectar com o servidor.';
            returns.style.color = 'red';
            console.error(err);
        }
    });
});
