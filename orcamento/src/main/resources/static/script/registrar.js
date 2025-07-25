document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('formRegister');
    const returns = document.getElementById('returns');

    if (!form) {
        console.error("Formulário com id 'formRegister' não encontrado.");
        return;
    }

    form.addEventListener('submit', async function (event) {
        event.preventDefault();

        const nameInput = document.getElementById('name');
        const emailInput = document.getElementById('email');
        const passwordInput = document.getElementById('password');

        if (!nameInput || !emailInput || !passwordInput) {
            console.error("Um ou mais campos do formulário não foram encontrados.");
            returns.textContent = 'Erro interno: campos ausentes no formulário.';
            returns.style.color = 'red';
            return;
        }

        const data = {
            name: nameInput.value.trim(),
            email: emailInput.value.trim(),
            password: passwordInput.value
        };

        try {
            const response = await fetch('/Users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                const responseText = await response.text();
                returns.textContent = '✅ Usuário cadastrado com sucesso!';
                returns.style.color = 'green';

                // Aguarda 1,5s para mostrar a mensagem e depois redireciona
                setTimeout(() => {
                    window.location.href = '/index.html';
                }, 1500);
            } else {
                const errorText = await response.text();
                returns.textContent = `❌ Erro: ${errorText}`;
                returns.style.color = 'red';
            }

        } catch (error) {
            returns.textContent = '❌ Erro ao conectar com o servidor.';
            returns.style.color = 'red';
            console.error('Erro na requisição:', error);
        }
    });
});
