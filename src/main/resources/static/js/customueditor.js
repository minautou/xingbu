window.onload = function () {
    $(document).ready(function () {
        var ue = UE.getEditor('container');
    });

    $(".tou-qu").on("click", function () {
        $(".toug").hide();
        $("#texts").val("");
        $("#image_box").find(".img-wrap").remove();
        $("#vjs_video").remove();
    });
}