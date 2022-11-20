var commitBtn = ['text-success', 'text-danger', 'text-primary', 'text-info', 'text-warning', 'text-muted']

function rand(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}


function getCommits(){
    // console.log("js - onload working...! ");

    $.ajax({
        url: "/github/kyu9/library/commits",
        type: "GET",
        success: function(data){
            console.log("Connection to Server Success")
            $.each(data.commitList, function(i){
                console.log(data.commitList[i].author)
                console.log(data.commitList[i].commitMsg)
                console.log(data.commitList[i].commitYYYYMMDD)

                var parent = document.getElementsByClassName("activity")[0]

                var outside = document.createElement("div")
                outside.className = "activity-item d-flex"

                var inside1 = document.createElement("div")
                inside1.className = "activite-label"
                var inside1_content = document.createTextNode("[" + data.commitList[i].author + "] " + data.commitList[i].commitYYYYMMDD)
                inside1.appendChild(inside1_content)
                outside.appendChild(inside1)

                var inside2 = document.createElement("i")
                inside2.className = 'bi bi-circle-fill activity-badge ' + commitBtn[rand(0, 5)] + ' align-self-start'
                outside.appendChild(inside2)

                var inside3 = document.createElement("div")
                inside3.className = "activity-content"
                var inside3_content = document.createTextNode(data.commitList[i].commitMsg)
                inside3.appendChild(inside3_content)
                outside.appendChild(inside3)

                parent.appendChild(outside)

            })
        },
        error: function(){
            console.log("Connection to Server Failed")
        }
    })
}

window.onload = getCommits();