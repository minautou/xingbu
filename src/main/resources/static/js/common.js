/**
 * page tool.
 */

window.onload = function () {
    // 分页组件begin
    var edges = 2,//两侧显示的页码数 大于1
        playes = 5,//主页码区显示的页码数 大于3
        pages = Math.ceil(total / pageSize);//总页数
    $(document).ready(function () {
        $('#myCarousel').carousel({interval: 4000}); //每隔4秒自动轮播
        renderPageItem();

        $("ul.nav li[name]").removeClass("active");
        switch (category) {
            case 'fortunetelling':
                if ($("ul.nav li[name='fortunetelling']")) {
                    $("ul.nav li[name='fortunetelling']").get(0).setAttribute("class", "active");
                }
                break;
            case 'fengshui':
                if ($("ul.nav li[name='fengshui']")) {
                    $("ul.nav li[name='fengshui']").get(0).setAttribute("class", "active");
                }
                break;
            case 'culture':
                if ($("ul.nav li[name='culture']")) {
                    $("ul.nav li[name='culture']").get(0).setAttribute("class", "active");
                }
                break;
            case 'column':
                if ($("ul.nav li[name='column']")) {
                    $("ul.nav li[name='column']").get(0).setAttribute("class", "active");
                }
                break;
            case 'classification':
                if ($("ul.nav li[name='classification']")) {
                    $("ul.nav li[name='classification']").get(0).setAttribute("class", "active");
                }
                break;
            default:
                $("ul.nav li[name='index']").get(0).setAttribute("class", "active");
        }
    });

    function renderPageItem() {
        $ul = $('<ul class="pagination"></ul>');
        var start = 1;
        var end = pages;
        if (pages < playes) {
            playes = pages;
        }
        if (playes % 2) {
            //playes是奇数
            start = pageNumber - Math.floor(playes / 2);
            end = pageNumber + Math.floor(playes / 2);
        } else {
            //playes是偶数
            start = pageNumber - (playes / 2 - 1);
            end = pageNumber + playes / 2;
        }

        if (start <= edges + 1) {
            start = 1;
            if (end < playes && playes < pages) {
                end = playes;
            }
        } else {
            for (var i = 1; i <= edges; i++) {
                $ul.append(renderItem(i));
            }
            $ul.append('<li><span>...</span></li>')
        }
        if (end < pages - edges) {
            for (var i = start; i <= end; i++) {
                $ul.append(renderItem(i));
            }
            $ul.append('<li><span>...</span></li>');
            for (var i = pages - edges + 1; i <= pages; i++) {
                $ul.append(renderItem(i));
            }
        } else {
            end = pages;
            if (start > pages - playes + 1) {
                start = pages - playes + 1
            }
            for (var i = start; i <= end; i++) {
                $ul.append(renderItem(i));
            }
        }
        $ul.prepend(renderPrevItem());
        $ul.append(renderNextItem());
        $('#pageBox').empty().append($ul);
    }

    function renderItem(i) {
        $item = $('<li><a href="#">' + i + '</a></li>');
        if (i == pageNumber || (pageNumber == null && i == 1)) {
            $item.addClass('active');
        }
        $item.on('click', (function (num) {
            return function () {
                pageNumber = num;
                renderPageAndData(pageNumber, pageSize);
                renderPageItem();
            }
        })(i));
        return $item
    }

    function renderPrevItem() {
        $prev = $('<li><a href="#">&laquo;</a></li>');
        if (pageNumber == 1) {
            $prev.addClass('disabled');
        } else {
            $prev.on('click', function () {
                pageNumber = pageNumber - 1;
                renderPageAndData(pageNumber, pageSize);
                renderPageItem();
            })
        }
        return $prev;
    }

    function renderNextItem() {
        $next = $('<li><a href="#">&raquo;</a></li>');
        if (pageNumber == pages) {
            $next.addClass('disabled');
        } else {
            $next.on('click', function () {
                pageNumber = pageNumber + 1;
                renderPageAndData(pageNumber, pageSize);
                renderPageItem();
            })
        }
        return $next;
    }

    function renderPageAndData(pageNumber, pageSize) {
        let urlStr;
        switch(category) {
            case 'fortunetelling':
                urlStr = "/articleView/fortune-telling";
                break;
            case 'fengshui':
                urlStr = "/articleView/fengshui";
                break;
            case 'culture':
                urlStr = "/articleView/culture";
                break;
            case 'column':
                urlStr = "/articleView/column";
                break;
            case 'classification':
                urlStr = "/articleView/classification";
                break;
            default:
                urlStr = "/index";
        }
        window.location.href = urlStr + '?pageNumber=' + pageNumber + '&pageSize=' + pageSize;
    }
    // 分页组件end


}
