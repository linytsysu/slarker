$(document).ready(function() {
    $("#user-button").click(toggleUserpanel);
});

function toggleUserpanel() {
    if (!$(".user-panel").is(':visible')) {
        $(".user-panel").show();
    } else {
        $(".user-panel").hide();
    }
}
