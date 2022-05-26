$(function () {
    const btns = $('#bracket li');
    const boxes = $('#linkBoxes > div');
    let currentIdx = 0;
    btns.click(function () {
        for (let i = 0; i < 3; i++) {
            if ($(this).is(btns[i])) {
                $(btns[currentIdx]).removeClass('selected');
                $(this).addClass('selected');
                $(boxes).css('margin-left', (-645 * i) + 'px');
                currentIdx = i;
            }
        }
    });
});