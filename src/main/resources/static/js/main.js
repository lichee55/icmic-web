$(function () {
    const btns = $('#bracket li');
    const circleBtns = $('#slideBtns > div');
    const boxes = $('#linkBoxes > div');
    let currentIdx = 0;

    const bodyStyle = getComputedStyle(document.body);
    const linkBoxWidth = bodyStyle.getPropertyValue('--linkBoxWidth').slice(0, -2) * 1;
    const linkBoxSpace = bodyStyle.getPropertyValue('--linkBoxSpace').slice(0, -2) * 1;

    selectSlide = function (i) {
        $(btns[currentIdx]).removeClass('selected');
        $(btns[i]).addClass('selected');

        $(circleBtns[currentIdx]).removeClass('selected');
        $(circleBtns[i]).addClass('selected');

        $(boxes).css('margin-left', (-3 * (linkBoxWidth + linkBoxSpace) * i) + 'px');
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