
$.ajax({
    type: "GET",
    url: "list.xml",
    dataType: "xml",
    success: function (xml) {

        $(xml).find("track").each(function () {
            let title = $(this).find("title").text();
            let creator = $(this).find("creator").text();
            let location = $(this).find("location").text();
            let data = "<li>" + "<a href=" + location + "> Title: " + title + "</a>" +
                "<p> Creator: " + creator + "</p>" + "</li>"

            $("#playlist").append(data)
            $("#playlist li:eq(" + 0 + ")").addClass("current-song");
        });
        
    }
})