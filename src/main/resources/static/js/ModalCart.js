var addCarts = document.querySelectorAll('.plus')
var box__cart = document.querySelector('.box__cart')
var closeCart = document.querySelector('.close-cart')

// add class hide vào element box__cart if don't exist or remove if class hide exist
function toggleCart() {
    box__cart.classList.toggle('hide')
}


// Show modal cart
addCarts.forEach(item => {
    item.addEventListener('click', toggleCart)
})

//close modal cart
closeCart.addEventListener('click', toggleCart)

// feature if user click outside modal then close modal
box__cart.addEventListener('click', function (e) {
    if(e.target == e.currentTarget) {
        toggleCart()
    }
})

