window.addEventListener('DOMContentLoaded', (event) => {
    calculateTotal();
});

function calculateTotal() {
    const quantities = document.querySelectorAll('.quantity input');
    const prices = document.querySelectorAll('td:nth-child(3)');
    const totals = document.querySelectorAll('td:nth-child(4)');

    let total = 0;

    for (let i = 0; i < quantities.length; i++) {
        const quantity = parseInt(quantities[i].value);
        const price = parseFloat(prices[i].innerText.replace('đ', '').replace(',', ''));
        const subtotal = quantity * price;

        totals[i].innerText = formatCurrency(subtotal);
        total += subtotal;
    }
    // const grandTotalElement = document.getElementById('grandTotal');
    // grandTotalElement.innerText = formatCurrency(total);
}

function formatCurrency(value) {
    const formattedValue = (value * 1000).toLocaleString('vi-VN');
    return formattedValue + 'đ';
}