async function analyze() {

    const data = {
        monthlyIncome: parseFloat(document.getElementById("income").value) || 6000,
        savings: parseFloat(document.getElementById("savings").value) || 30000,
        downPaymentPercent: parseFloat(document.getElementById("downPayment").value) || 0.2,
        interestRate: parseFloat(document.getElementById("interestRate").value) || 0.065,
        riskTolerance: parseFloat(document.getElementById("risk").value) || 0.5
    };

    const response = await fetch("http://localhost:8080/api/properties/analyze", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });

    const properties = await response.json();

    display(properties);
}

function display(properties) {

    const container = document.getElementById("results");
    container.innerHTML = "";

    properties.forEach((p, index) => {

        let color = getColor(p.finalScore);

        let insightsHTML = "";
        p.insights.forEach(i => {
            insightsHTML += `<li>${i}</li>`;
        });

        const card = `
        <div class="card">
            <h3>${p.title}</h3>

            <p><strong>Monthly Cost:</strong> $${p.monthlyCost.toFixed(2)}</p>

            <p class="score ${color}">
                Final Score: ${p.finalScore}
            </p>

            <p>Affordability: ${p.affordabilityScore}</p>
            <p>Trust Score: ${p.trustScore}</p>

            <h4>Insights</h4>
            <ul>${insightsHTML}</ul>
        </div>
        `;

        container.innerHTML += card;
    });
}

function getColor(score) {
    if (score >= 80) return "green";
    if (score >= 50) return "orange";
    return "red";
}