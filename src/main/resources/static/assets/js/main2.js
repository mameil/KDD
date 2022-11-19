function getCommits(){
    // console.log("js - onload working...! ");

    $.ajax({
        url: "/"
    })
}

window.onload = getCommits();