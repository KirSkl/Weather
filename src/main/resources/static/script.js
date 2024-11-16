document.getElementById('weatherForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const city = document.getElementById('city').value;
    const days = document.getElementById('days').value;

    fetch(`http://localhost:9090/forecast?city=${encodeURIComponent(city)}&days=${days}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("weatherContainer").innerHTML = "";
            document.getElementById("warningContainer").innerHTML = "";

            Object.entries(data.temperature).forEach(([day, temp]) => {
                const div = document.createElement('div');
                div.innerText = `${day}: ${temp}`;
                document.getElementById('weatherContainer').appendChild(div);
            });

            if (data.warnings.length > 0) {
                data.warnings.forEach(warning => {
                    const warningDiv = document.createElement('div');
                    warningDiv.classList.add('warning');
                    warningDiv.innerText = warning;
                    document.getElementById('warningContainer').appendChild(warningDiv);
                });
            }

            document.getElementById("errorMessage").innerText = "";
        })
        .catch(error => {
            console.error('Ошибка:', error);
            document.getElementById('errorMessage').innerText = 'Произошла ошибка при получении данных.';
        });
});