
document.addEventListener('DOMContentLoaded', function() {

    const loginForm = document.getElementById('login-form');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            // Dummy login functionality
            window.location.href = '/menu';
        });
    }


    const productForm = document.getElementById('product-form');
    const messageDiv = document.getElementById('message');
    const productList = document.getElementById('product-list');

    if (productForm) {
        productForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const name = document.getElementById('name').value;
            const price = document.getElementById('price').value;
            const description = document.getElementById('description').value;
            const category = document.getElementById('category').value;

            const product = {
                name,
                price: parseFloat(price),
                description,
                category
            };

            fetch('/products/update', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(product)
            })
                .then(response => response.json())
                .then(data => {
                    messageDiv.textContent = 'Produkt erfolgreich hinzugefügt!';
                    productForm.reset();
                    addProductToList(data);
                })
                .catch(error => {
                    console.error('Error:', error);
                    messageDiv.textContent = 'Fehler beim Hinzufügen des Produkts.';
                });
        });

        function addProductToList(product) {
            const li = document.createElement('li');
            li.textContent = `${product.name} - €${product.price.toFixed(2)} - ${product.description} - ${product.category}`;
            productList.appendChild(li);
        }

        function loadProducts() {
            fetch('/products')
                .then(response => response.json())
                .then(data => {
                    data.forEach(product => {
                        addProductToList(product);
                    });
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

        loadProducts();
    }


    const cartList = document.getElementById('cart-list');
    const checkoutButton = document.getElementById('checkout-button');

    if (cartList) {
        let cart = JSON.parse(localStorage.getItem('cart')) || [];

        function addProductToCart(product) {
            cart.push(product);
            localStorage.setItem('cart', JSON.stringify(cart));
            renderCart();
        }

        function renderCart() {
            cartList.innerHTML = '';
            cart.forEach((product, index) => {
                const li = document.createElement('li');
                li.textContent = `${product.name} - €${product.price.toFixed(2)} - ${product.description} - ${product.category}`;
                cartList.appendChild(li);
            });
        }

        if (checkoutButton) {
            checkoutButton.addEventListener('click', function() {
                window.location.href = '/payment';
            });
        }

        renderCart();
    }

    const paymentForm = document.getElementById('payment-form');
    const paymentMessageDiv = document.getElementById('payment-message');

    if (paymentForm) {
        paymentForm.addEventListener('submit', function(event) {
            event.preventDefault();
            // Dummy payment processing
            paymentMessageDiv.textContent = 'Zahlung erfolgreich!';
            localStorage.removeItem('cart');
        });
    }
});
