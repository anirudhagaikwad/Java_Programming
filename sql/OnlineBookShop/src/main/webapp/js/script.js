// Utility function to create DOM elements safely
function createElement(tag, className, innerHTML) {
    const element = document.createElement(tag);
    if (className) element.className = className;
    if (innerHTML) element.innerHTML = innerHTML; // Use with sanitized data only
    return element;
}

// Utility to escape HTML to prevent XSS
function escapeHTML(str) {
    return str.replace(/[&<>"']/g, match => ({
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#39;'
    }[match]));
}

// Fetch and display books
function fetchBooks() {
    const search = document.getElementById("search")?.value || "";
    fetch(`/online-bookshop/books?search=${encodeURIComponent(search)}`)
        .then(response => {
            if (!response.ok) throw new Error("Failed to fetch books");
            return response.json();
        })
        .then(books => {
            const bookList = document.getElementById("book-list");
            if (!bookList) return;
            bookList.innerHTML = "";
            books.forEach(book => {
                const div = createElement("div", "book");
                div.innerHTML = `
                    <h3>${escapeHTML(book.title)}</h3>
                    <p>Price: $${book.price.toFixed(2)} | Stock: ${book.stock}</p>
                    <button onclick="addToCart(${book.id})" ${book.stock === 0 ? "disabled" : ""}>Add to Cart</button>
                `;
                bookList.appendChild(div);
            });
        })
        .catch(error => {
            console.error("Error fetching books:", error);
            const bookList = document.getElementById("book-list");
            if (bookList) bookList.innerHTML = "<p>Error loading books. Please try again later.</p>";
        });
}

// Add a book to the cart
function addToCart(bookId) {
    fetch("/online-bookshop/cart/add", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `bookId=${bookId}`
    })
        .then(response => {
            if (!response.ok) throw new Error("Failed to add to cart");
            return response.text();
        })
        .then(message => {
            showFeedback(message, "success");
            fetchBooks(); // Refresh stock
        })
        .catch(error => {
            console.error("Error adding to cart:", error);
            showFeedback("Failed to add to cart", "error");
        });
}

// View cart contents
function viewCart() {
    fetch("/online-bookshop/cart/view")
        .then(response => {
            if (!response.ok) throw new Error("Failed to fetch cart");
            return response.json();
        })
        .then(cart => {
            const cartList = document.getElementById("cart-list");
            if (!cartList) return;
            cartList.innerHTML = "";
            if (cart.length === 0) {
                cartList.innerHTML = "<p>Your cart is empty.</p>";
                return;
            }
            cart.forEach(item => {
                const div = createElement("div", "cart-item");
                div.innerHTML = `
                    <h3>${escapeHTML(item.title)}</h3>
                    <p>Price: $${item.price.toFixed(2)} | Quantity: 
                        <input type="number" value="${item.quantity}" min="0" onchange="updateCart(${item.id}, this.value)">
                    </p>
                `;
                cartList.appendChild(div);
            });
        })
        .catch(error => {
            console.error("Error viewing cart:", error);
            const cartList = document.getElementById("cart-list");
            if (cartList) cartList.innerHTML = "<p>Error loading cart. Please try again later.</p>";
        });
}

// Update cart quantity
function updateCart(bookId, quantity) {
    fetch("/online-bookshop/cart/update", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `bookId=${bookId}&quantity=${quantity}`
    })
        .then(response => {
            if (!response.ok) throw new Error("Failed to update cart");
            return response.text();
        })
        .then(message => {
            showFeedback(message, "success");
            viewCart();
        })
        .catch(error => {
            console.error("Error updating cart:", error);
            showFeedback("Failed to update cart", "error");
        });
}

// Process checkout
function checkout() {
    fetch("/online-bookshop/order/checkout", { method: "POST" })
        .then(response => {
            if (response.redirected) {
                window.location.href = response.url; // Redirect to login if not authenticated
                return;
            }
            if (!response.ok) throw new Error("Checkout failed");
            showFeedback("Checkout successful!", "success");
            viewCart(); // Clear cart display
        })
        .catch(error => {
            console.error("Error during checkout:", error);
            showFeedback("Checkout failed. Please try again.", "error");
        });
}

// Fetch and display order history
function fetchOrders() {
    fetch("/online-bookshop/order/history")
        .then(response => {
            if (!response.ok) throw new Error("Failed to fetch orders");
            return response.json();
        })
        .then(orders => {
            const orderList = document.getElementById("order-list");
            if (!orderList) return;
            orderList.innerHTML = "";
            if (orders.length === 0) {
                orderList.innerHTML = "<p>No orders found.</p>";
                return;
            }
            orders.forEach(order => {
                const div = createElement("div", "order");
                div.innerHTML = `
                    <h3>Order #${order.id}</h3>
                    <p>Date: ${new Date(order.date).toLocaleString()} | Total: $${order.total.toFixed(2)} | Status: ${escapeHTML(order.status)}</p>
                `;
                orderList.appendChild(div);
            });
        })
        .catch(error => {
            console.error("Error fetching orders:", error);
            const orderList = document.getElementById("order-list");
            if (orderList) orderList.innerHTML = "<p>Error loading orders. Please try again later.</p>";
        });
}

// Logout
function logout() {
    fetch("/online-bookshop/user/logout")
        .then(response => {
            if (!response.ok) throw new Error("Logout failed");
            window.location.href = "/online-bookshop/index.html";
        })
        .catch(error => {
            console.error("Error logging out:", error);
            showFeedback("Logout failed", "error");
        });
}

// Show user feedback
function showFeedback(message, type) {
    const feedback = document.createElement("div");
    feedback.textContent = message;
    feedback.style.color = type === "success" ? "green" : "red";
    feedback.style.position = "fixed";
    feedback.style.top = "10px";
    feedback.style.right = "10px";
    document.body.appendChild(feedback);
    setTimeout(() => feedback.remove(), 3000);
}

// Debounced search for fetchBooks
let debounceTimeout;
function debounceFetchBooks() {
    clearTimeout(debounceTimeout);
    debounceTimeout = setTimeout(fetchBooks, 300); // Wait 300ms after last keystroke
}

// Initialize page-specific content
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("book-list")) fetchBooks();
    if (document.getElementById("cart-list")) viewCart();
    if (document.getElementById("order-list")) fetchOrders();
    const searchInput = document.getElementById("search");
    if (searchInput) searchInput.addEventListener("keyup", debounceFetchBooks);
});