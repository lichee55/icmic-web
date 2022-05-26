$(function () {
    const btns = $('#bracket li');
    const circleBtns = $('#slideBtns > div');
    const boxes = $('#linkBoxes > div');
    let currentIdx = 0;

    selectSlide = function (i) {
        $(btns[currentIdx]).removeClass('selected');
        $(btns[i]).addClass('selected');

        $(circleBtns[currentIdx]).removeClass('selected');
        $(circleBtns[i]).addClass('selected');

        $(boxes).css('margin-left', (-645 * i) + 'px');
        currentIdx = i;
    };

    btns.click(function () {
        for (let i = 0; i < 3; i++) {
            if ($(this).is(btns[i])) {
                selectSlide(i);
            }
        }
    });

    circleBtns.click(function () {
        for (let i = 0; i < 3; i++) {
            if ($(this).is(circleBtns[i])) {
                selectSlide(i);
            }
        }
    });
});