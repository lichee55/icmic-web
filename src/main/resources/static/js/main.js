$(function () {
    const btns = $('.bracket li');
    const boxes = $('.linkBoxes ul');
    let currentIdx = 0;
    btns.click(function () {
        for (let i = 0; i < 3; i++) {
            if ($(this).is(btns[i])) {
                $(btns[currentIdx]).removeClass('selected');
                $(boxes[currentIdx]).removeClass('selected');

                $(this).addClass('selected');
                $(boxes[i]).addClass('selected');
                currentIdx = i;
            }
        }
    });
});