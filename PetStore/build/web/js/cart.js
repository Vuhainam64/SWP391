function updateQuantity(input) {
    // Find the parent form element
    var form = input.closest('form');
    // Submit the form
    form.submit();
}

/*-------------------
 Quantity change
 --------------------- */
var proQty = $('.pro-qty');
proQty.on('click', '.qtybtn', function () {
    var $button = $(this);
    var oldValue = $button.parent().find('input').val();
    if ($button.hasClass('inc')) {
        var newVal = parseFloat(oldValue) + 1;
    } else {
        // Don't allow decrementing below zero
        if (oldValue > 0) {
            var newVal = parseFloat(oldValue) - 1;
        } else {
            newVal = 0;
        }
    }
    $button.parent().find('input').val(newVal);
});