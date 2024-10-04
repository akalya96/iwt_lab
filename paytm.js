document.getElementById('customer-payment-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Customer Payment Processed!');
});

document.getElementById('artist-payment-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Artist Payment Processed!');
});
