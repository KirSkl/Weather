document.getElementById('weatherForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const city = document.getElementById('city').value;
    const days = document.getElementById('days').value;

    fetch(`http://localhost:8080/forecast?city=${encodeURIComponent(city)}&days=${days}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Очистка контейнера перед выводом новой информации
            document.getElementById("weatherContainer").innerHTML = "";
            document.getElementById("warningContainer").innerHTML = ""; // Контейнер для предупреждений

            // Вывод температуры
            Object.entries(data.temperature).forEach(([day, temp]) => {
                const div = document.createElement('div');
                div.innerText = `${day}: ${temp}`;
                document.getElementById('weatherContainer').appendChild(div);
            });

            // Вывод предупреждений
            if (data.warnings.length > 0) {
                data.warnings.forEach(warning => {
                    const warningDiv = document.createElement('div');
                    warningDiv.classList.add('warning'); // Класс для стилей предупреждений
                    warningDiv.innerText = warning;
                    document.getElementById('warningContainer').appendChild(warningDiv);
                });
            }

            // Скрываем сообщение об ошибке
            document.getElementById("errorMessage").innerText = "";
        })
        .catch(error => {
            console.error('Ошибка:', error);
            document.getElementById('errorMessage').innerText = 'Произошла ошибка при получении данных.';
        });
});